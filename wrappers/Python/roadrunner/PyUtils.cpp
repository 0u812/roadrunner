/*
 * PyUtils.cpp
 *
 *  Created on: Apr 27, 2014
 *      Author: andy
 */

#include <stdexcept>
#include <string>

// wierdness on OSX clang, this needs to be included before python.h,
// otherwise compile pukes with:
// localefwd.h error: too many arguments provided to function-like macro invocation
#include <sstream>
#include <vector>
#include <PyUtils.h>
#include <rrLogger.h>
#include <Dictionary.h>




using namespace std;

namespace rr
{


PyObject* Variant_to_py(const Variant& var)
{
    PyObject *result = 0;

    const std::type_info &type = var.typeInfo();

    if (var.isEmpty()) {
        Py_RETURN_NONE;
    }

    if (type == typeid(std::string)) {
        return PyString_FromString(var.convert<string>().c_str());
    }

    if (type == typeid(bool)) {
        return PyBool_FromLong(var.convert<bool>());
    }

    if (type == typeid(unsigned long)) {
        return PyLong_FromUnsignedLong(var.convert<unsigned long>());
    }

    if (type == typeid(long)) {
        return PyLong_FromLong(var.convert<long>());
    }

    if (type == typeid(int)) {
        return PyInt_FromLong(var.convert<long>());
    }

    if (type == typeid(unsigned int)) {
        return PyLong_FromUnsignedLong(var.convert<unsigned long>());
    }

    if (type == typeid(char)) {
        char c = var.convert<char>();
        return PyString_FromStringAndSize(&c, 1);
    }

    if (type == typeid(unsigned char)) {
        return PyInt_FromLong(var.convert<long>());
    }

    if (type == typeid(float) || type == typeid(double)) {
        return PyFloat_FromDouble(var.convert<double>());
    }


    throw invalid_argument("could not convert " + var.toString() + "to Python object");
}

Variant Variant_from_py(PyObject* py)
{
    Variant var;

    if(py == Py_None)
    {
        return var;
    }

    if (PyString_Check(py))
    {
        var = std::string(PyString_AsString(py));
        return var;
    }

    else if (PyBool_Check(py))
    {
        var = (bool)(py == Py_True);
        return var;
    }

    else if (PyLong_Check(py))
    {
        // need to check for overflow.
        var = (long)PyLong_AsLong(py);

        // Borrowed reference.
        PyObject* err = PyErr_Occurred();
        if (err) {
            std::stringstream ss;
            ss << "Could not convert Python long to C ";
            ss << sizeof(long) * 8 << " bit long: ";
            ss << std::string(PyString_AsString(err));

            // clear error, raise our own
            PyErr_Clear();

            invalid_argument(ss.str());
        }

        return var;
    }

    else if (PyInt_Check(py))
    {
        var = (int)PyInt_AsLong(py);
        return var;
    }

    else if (PyFloat_Check(py))
    {
        var = (double)PyFloat_AsDouble(py);
        return var;
    }

    string msg = "could not convert Python type to built in type";
    throw invalid_argument(msg);
}

PyObject* dictionary_keys(const Dictionary* dict)
{
    std::vector<std::string> keys = dict->getKeys();

    unsigned size = keys.size();

    PyObject* pyList = PyList_New(size);

    unsigned j = 0;

    for (std::vector<std::string>::const_iterator i = keys.begin(); i != keys.end(); ++i)
    {
        const std::string& key  = *i;
        PyObject* pyStr = PyString_FromString(key.c_str());
        PyList_SET_ITEM(pyList, j++, pyStr);
    }

    return pyList;
}

PyObject* dictionary_values(const Dictionary* dict)
{
    std::vector<std::string> keys = dict->getKeys();

    unsigned size = keys.size();

    PyObject* pyList = PyList_New(size);

    unsigned j = 0;

    for (std::vector<std::string>::const_iterator i = keys.begin(); i != keys.end(); ++i)
    {
        const std::string& key  = *i;
        PyObject* pyVal = Variant_to_py(dict->getItem(key));
        PyList_SET_ITEM(pyList, j++, pyVal);
    }

    return pyList;
}

PyObject* dictionary_items(const Dictionary* dict)
{
    std::vector<std::string> keys = dict->getKeys();

    unsigned size = keys.size();

    PyObject* pyList = PyList_New(size);

    unsigned j = 0;

    for (std::vector<std::string>::const_iterator i = keys.begin(); i != keys.end(); ++i)
    {
        const std::string& key  = *i;
        PyObject* pyStr = Variant_to_py(dict->getItem(key));

        PyObject *pyKey = PyString_FromString(key.c_str());
        PyObject *pyVal = Variant_to_py(dict->getItem(key));
        PyObject *tup = PyTuple_Pack(2, pyKey, pyVal);

        Py_DECREF(pyKey);
        Py_DECREF(pyVal);

        // list takes ownershipt of tuple
        PyList_SET_ITEM(pyList, j++, tup);
    }

    return pyList;
}

PyObject* dictionary_getitem(const Dictionary* dict, const char* key)
{
    return Variant_to_py(dict->getItem(key));
}

PyObject* dictionary_setitem(Dictionary* dict, const char* key, PyObject* value)
{
    dict->setItem(key, Variant_from_py(value));
    Py_RETURN_NONE;
}

void dictionary_delitem(Dictionary* dict, const char* key)
{
    dict->deleteItem(key);
}

PyObject* dictionary_contains(const Dictionary* dict, const char* key)
{
    bool contains = dict->hasKey(key);
    return PyBool_FromLong(contains);
}

} /* namespace rr */

