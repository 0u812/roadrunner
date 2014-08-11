/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.4
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.sbml.libsbml;

/** 
 *  Log of diagnostics reported during XML processing.
 <p>
 * <p style='color: #777; font-style: italic'>
This class of objects is defined by libSBML only and has no direct
equivalent in terms of SBML components.  This class is not prescribed by
the SBML specifications, although it is used to implement features
defined in SBML.
</p>

 <p>
 * The error log is a list.  The XML layer of libSBML maintains an error
 * log associated with a given XML document or data stream.  When an
 * operation results in an error, or when there is something wrong with the
 * XML content, the problem is reported as an {@link XMLError} object stored in the
 * {@link XMLErrorLog} list.  Potential problems range from low-level issues (such
 * as the inability to open a file) to XML syntax errors (such as
 * mismatched tags or other problems).
 <p>
 * A typical approach for using this error log is to first use
 * {@link XMLErrorLog#getNumErrors()}
 * to inquire how many {@link XMLError} object instances it contains, and then to
 * iterate over the list of objects one at a time using
 * getError(long n) const.  Indexing in the list begins at 0.
 <p>
 * In normal circumstances, programs using libSBML will actually obtain an
 * {@link SBMLErrorLog} rather than an {@link XMLErrorLog}.  The former is subclassed from
 * {@link XMLErrorLog} and simply wraps commands for working with {@link SBMLError} objects
 * rather than the low-level {@link XMLError} objects.  Classes such as
 * {@link SBMLDocument} use the higher-level {@link SBMLErrorLog}.
 */

public class XMLErrorLog {
   private long swigCPtr;
   protected boolean swigCMemOwn;

   protected XMLErrorLog(long cPtr, boolean cMemoryOwn)
   {
     swigCMemOwn = cMemoryOwn;
     swigCPtr    = cPtr;
   }

   protected static long getCPtr(XMLErrorLog obj)
   {
     return (obj == null) ? 0 : obj.swigCPtr;
   }

   protected static long getCPtrAndDisown (XMLErrorLog obj)
   {
     long ptr = 0;

     if (obj != null)
     {
       ptr             = obj.swigCPtr;
       obj.swigCMemOwn = false;
     }

     return ptr;
   }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        libsbmlJNI.delete_XMLErrorLog(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  /**
   * Equality comparison method for XMLErrorLog.
   * <p>
   * Because the Java methods for libSBML are actually wrappers around code
   * implemented in C++ and C, certain operations will not behave as
   * expected.  Equality comparison is one such case.  An instance of a
   * libSBML object class is actually a <em>proxy object</em>
   * wrapping the real underlying C/C++ object.  The normal <code>==</code>
   * equality operator in Java will <em>only compare the Java proxy objects</em>,
   * not the underlying native object.  The result is almost never what you
   * want in practical situations.  Unfortunately, Java does not provide a
   * way to override <code>==</code>.
   *  <p>
   * The alternative that must be followed is to use the
   * <code>equals()</code> method.  The <code>equals</code> method on this
   * class overrides the default java.lang.Object one, and performs an
   * intelligent comparison of instances of objects of this class.  The
   * result is an assessment of whether two libSBML Java objects are truly 
   * the same underlying native-code objects.
   *  <p>
   * The use of this method in practice is the same as the use of any other
   * Java <code>equals</code> method.  For example,
   * <em>a</em><code>.equals(</code><em>b</em><code>)</code> returns
   * <code>true</code> if <em>a</em> and <em>b</em> are references to the
   * same underlying object.
   *
   * @param sb a reference to an object to which the current object
   * instance will be compared
   *
   * @return <code>true</code> if <code>sb</code> refers to the same underlying 
   * native object as this one, <code>false</code> otherwise
   */
  public boolean equals(Object sb)
  {
    if ( this == sb ) 
    {
      return true;
    }
    return swigCPtr == getCPtr((XMLErrorLog)(sb));
  }

  /**
   * Returns a hashcode for this XMLErrorLog object.
   *
   * @return a hash code usable by Java methods that need them.
   */
  public int hashCode()
  {
    return (int)(swigCPtr^(swigCPtr>>>32));
  }

  
/**
   * Returns the number of errors that have been logged.
   <p>
   * To retrieve individual errors from the log, callers may use
   * {@link XMLErrorLog#getError(long n)} .
   <p>
   * @return the number of errors that have been logged.
   */ public
 long getNumErrors() {
    return libsbmlJNI.XMLErrorLog_getNumErrors(swigCPtr, this);
  }

  
/**
   * Returns the <i>n</i>th {@link XMLError} object in this log.
   <p>
   * Index <code>n</code> is counted from 0.  Callers should first inquire about the
   * number of items in the log by using the method
   * {@link XMLErrorLog#getNumErrors()}.
   * Attempts to use an error index number that exceeds the actual number
   * of errors in the log will result in a <code>null</code> being returned.
   <p>
   * @param n the index number of the error to retrieve (with 0 being the
   * first error).
   <p>
   * @return the <i>n</i>th {@link XMLError} in this log, or <code>null</code> if <code>n</code> is
   * greater than or equal to
   * {@link XMLErrorLog#getNumErrors()}.
   <p>
   * @see #getNumErrors()
   */ public
 XMLError getError(long n) {
    long cPtr = libsbmlJNI.XMLErrorLog_getError(swigCPtr, this, n);
    return (cPtr == 0) ? null : new XMLError(cPtr, false);
  }

  
/**
   * Deletes all errors from this log.
   */ public
 void clearLog() {
    libsbmlJNI.XMLErrorLog_clearLog(swigCPtr, this);
  }

  
/**
   * Creates a new empty {@link XMLErrorLog}.
   * @internal
   */ public
 XMLErrorLog() {
    this(libsbmlJNI.new_XMLErrorLog__SWIG_0(), true);
  }

  
/**
   * Copy Constructor
   * @internal
   */ public
 XMLErrorLog(XMLErrorLog other) {
    this(libsbmlJNI.new_XMLErrorLog__SWIG_1(XMLErrorLog.getCPtr(other), other), true);
  }

  
/**
   * Logs the given {@link XMLError}.
   <p>
   * @param error {@link XMLError}, the error to be logged.
   * @internal
   */ public
 void add(XMLError error) {
    libsbmlJNI.XMLErrorLog_add__SWIG_0(swigCPtr, this, XMLError.getCPtr(error), error);
  }

  
/**
   * Logs (copies) the XMLErrors in the given {@link XMLError} list to this
   * {@link XMLErrorLog}.
   <p>
   * @param errors list, a list of {@link XMLError} to be added to the log.
   * @internal
   */ public
 void add(SWIGTYPE_p_std__vectorT_XMLError_p_t errors) {
    libsbmlJNI.XMLErrorLog_add__SWIG_1(swigCPtr, this, SWIGTYPE_p_std__vectorT_XMLError_p_t.getCPtr(errors));
  }

  
/**
   * Writes all errors contained in this log to a string and returns it.
   <p>
   * This method uses printErrors() to format the diagnostic messages.
   * Please consult that method for information about the organization
   * of the messages in the string returned by this method.
   <p>
   * @return a string containing all logged errors and warnings.
   <p>
   * @see #printErrors()
   */ public
 String toString() {
    return libsbmlJNI.XMLErrorLog_toString(swigCPtr, this);
  }

  
/**
   * Prints all the errors or warnings stored in this error log.
   <p>
   * This method prints the text to the stream given by the optional
   * parameter <code>stream</code>.  If no stream is given, the method prints the
   * output to the standard error stream.
   <p>
   * The format of the output is:
   * <pre class='fragment'>
   N error(s):
     line NNN: (id) message
 </pre>
   * If no errors have occurred, i.e.,
   * <code>getNumErrors() == 0</code>, then no output will be produced.
<p>
   * @param stream the ostream or ostringstream object indicating where
   * the output should be printed.
   <p>
   * 
</dl><dl class="docnote"><dt><b>Documentation note:</b></dt><dd>
The native C++ implementation of this method defines a default argument
value. In the documentation generated for different libSBML language
bindings, you may or may not see corresponding arguments in the method
declarations. For example, in Java and C#, a default argument is handled by
declaring two separate methods, with one of them having the argument and
the other one lacking the argument. However, the libSBML documentation will
be <em>identical</em> for both methods. Consequently, if you are reading
this and do not see an argument even though one is described, please look
for descriptions of other variants of this method near where this one
appears in the documentation.
</dd></dl>
 
   */ public
 void printErrors(OStream stream) {
    libsbmlJNI.XMLErrorLog_printErrors__SWIG_0(swigCPtr, this, SWIGTYPE_p_std__ostream.getCPtr(stream.get_ostream()), stream);
  }

  
/**
   * Prints all the errors or warnings stored in this error log.
   <p>
   * This method prints the text to the stream given by the optional
   * parameter <code>stream</code>.  If no stream is given, the method prints the
   * output to the standard error stream.
   <p>
   * The format of the output is:
   * <pre class='fragment'>
   N error(s):
     line NNN: (id) message
 </pre>
   * If no errors have occurred, i.e.,
   * <code>getNumErrors() == 0</code>, then no output will be produced.
<p>
   * @param stream the ostream or ostringstream object indicating where
   * the output should be printed.
   <p>
   * 
</dl><dl class="docnote"><dt><b>Documentation note:</b></dt><dd>
The native C++ implementation of this method defines a default argument
value. In the documentation generated for different libSBML language
bindings, you may or may not see corresponding arguments in the method
declarations. For example, in Java and C#, a default argument is handled by
declaring two separate methods, with one of them having the argument and
the other one lacking the argument. However, the libSBML documentation will
be <em>identical</em> for both methods. Consequently, if you are reading
this and do not see an argument even though one is described, please look
for descriptions of other variants of this method near where this one
appears in the documentation.
</dd></dl>
 
   */ public
 void printErrors() {
    libsbmlJNI.XMLErrorLog_printErrors__SWIG_1(swigCPtr, this);
  }

  
/**
   * Returns a boolean indicating whether or not the severity has been
   * overridden.
   <p>
   * <p>
 * The <em>severity override</em> mechanism in {@link XMLErrorLog} is intended to help
 * applications handle error conditions in ways that may be more convenient
 * for those applications.  It is possible to use the mechanism to override
 * the severity code of errors logged by libSBML, and even to disable error
 * logging completely.  An override stays in effect until the override is
 * changed again by the calling application.
   <p>
   * @return <code>true</code> if an error severity override has been set, <code>false</code>
   * otherwise.
   <p>
   * @see #getSeverityOverride()
   * @see #setSeverityOverride(int)
   * @see #unsetSeverityOverride()
   * @see #changeErrorSeverity(int, int, String)
   */ public
 boolean isSeverityOverridden() {
    return libsbmlJNI.XMLErrorLog_isSeverityOverridden(swigCPtr, this);
  }

  
/**
   * Usets an existing override.
   <p>
   * <p>
 * The <em>severity override</em> mechanism in {@link XMLErrorLog} is intended to help
 * applications handle error conditions in ways that may be more convenient
 * for those applications.  It is possible to use the mechanism to override
 * the severity code of errors logged by libSBML, and even to disable error
 * logging completely.  An override stays in effect until the override is
 * changed again by the calling application.
   <p>
   * @see #getSeverityOverride()
   * @see #setSeverityOverride(int)
   * @see #isSeverityOverridden()
   * @see #changeErrorSeverity(int, int, String)
   */ public
 void unsetSeverityOverride() {
    libsbmlJNI.XMLErrorLog_unsetSeverityOverride(swigCPtr, this);
  }

  
/**
   * Returns the current override.
   <p>
   * <p>
 * The <em>severity override</em> mechanism in {@link XMLErrorLog} is intended to help
 * applications handle error conditions in ways that may be more convenient
 * for those applications.  It is possible to use the mechanism to override
 * the severity code of errors logged by libSBML, and even to disable error
 * logging completely.  An override stays in effect until the override is
 * changed again by the calling application.
   <p>
   * @return a severity override code.  The possible values are :
   * <ul>
   * <li> {@link libsbmlConstants#LIBSBML_OVERRIDE_DISABLED LIBSBML_OVERRIDE_DISABLED}
   * <li> {@link libsbmlConstants#LIBSBML_OVERRIDE_DONT_LOG LIBSBML_OVERRIDE_DONT_LOG}
   * <li> {@link libsbmlConstants#LIBSBML_OVERRIDE_WARNING LIBSBML_OVERRIDE_WARNING}
   *
   * </ul> <p>
   * @see #isSeverityOverridden()
   * @see #setSeverityOverride(int)
   * @see #unsetSeverityOverride()
   * @see #changeErrorSeverity(int, int, String)
   */ public
 int getSeverityOverride() {
    return libsbmlJNI.XMLErrorLog_getSeverityOverride(swigCPtr, this);
  }

  
/**
   * Set the severity override.
   <p>
   * <p>
 * The <em>severity override</em> mechanism in {@link XMLErrorLog} is intended to help
 * applications handle error conditions in ways that may be more convenient
 * for those applications.  It is possible to use the mechanism to override
 * the severity code of errors logged by libSBML, and even to disable error
 * logging completely.  An override stays in effect until the override is
 * changed again by the calling application.
   <p>
   * @param severity an override code indicating what to do.  If the value is
   * {@link libsbmlConstants#LIBSBML_OVERRIDE_DISABLED LIBSBML_OVERRIDE_DISABLED}
   * (the default setting) all errors logged will be given the severity
   * specified in their usual definition.   If the value is
   * {@link libsbmlConstants#LIBSBML_OVERRIDE_WARNING LIBSBML_OVERRIDE_WARNING},
   * then all errors will be logged as warnings.  If the value is 
   * {@link libsbmlConstants#LIBSBML_OVERRIDE_DONT_LOG LIBSBML_OVERRIDE_DONT_LOG},
   * no error will be logged, regardless of their severity.
   <p>
   * @see #isSeverityOverridden()
   * @see #getSeverityOverride()
   * @see #unsetSeverityOverride()
   * @see #changeErrorSeverity(int, int, String)
   */ public
 void setSeverityOverride(int severity) {
    libsbmlJNI.XMLErrorLog_setSeverityOverride(swigCPtr, this, severity);
  }

  
/**
   * Changes the severity override for errors in the log that have a given
   * severity.
   <p>
   * This method searches through the list of errors in the log, comparing
   * each one's severity to the value of <code>originalSeverity</code>.  For each error
   * encountered with that severity logged by the named <code>package</code>, the
   * severity of the error is reset to <code>targetSeverity</code>.
   <p>
   * <p>
 * The <em>severity override</em> mechanism in {@link XMLErrorLog} is intended to help
 * applications handle error conditions in ways that may be more convenient
 * for those applications.  It is possible to use the mechanism to override
 * the severity code of errors logged by libSBML, and even to disable error
 * logging completely.  An override stays in effect until the override is
 * changed again by the calling application.
   <p>
   * @param originalSeverity the severity code to match
   <p>
   * @param targetSeverity the severity code to use as the new severity
   <p>
   * @param package a string, the name of an SBML Level&nbsp;3 package
   * extension to use to narrow the search for errors.  A value of <code>'all'</code>
   * signifies to match against errors logged from any package; a value of a
   * package nickname such as <code>'comp'</code> signifies to limit consideration to
   * errors from just that package.  If no value is provided, <code>'all'</code> is the
   * default.
   <p>
   * 
</dl><dl class="docnote"><dt><b>Documentation note:</b></dt><dd>
The native C++ implementation of this method defines a default argument
value. In the documentation generated for different libSBML language
bindings, you may or may not see corresponding arguments in the method
declarations. For example, in Java and C#, a default argument is handled by
declaring two separate methods, with one of them having the argument and
the other one lacking the argument. However, the libSBML documentation will
be <em>identical</em> for both methods. Consequently, if you are reading
this and do not see an argument even though one is described, please look
for descriptions of other variants of this method near where this one
appears in the documentation.
</dd></dl>
 
   <p>
   * @see #isSeverityOverridden()
   * @see #getSeverityOverride()
   * @see #setSeverityOverride(int)
   * @see #unsetSeverityOverride()
   */ public
 void changeErrorSeverity(int originalSeverity, int targetSeverity, String arg2) {
    libsbmlJNI.XMLErrorLog_changeErrorSeverity__SWIG_0(swigCPtr, this, originalSeverity, targetSeverity, arg2);
  }

  
/**
   * Changes the severity override for errors in the log that have a given
   * severity.
   <p>
   * This method searches through the list of errors in the log, comparing
   * each one's severity to the value of <code>originalSeverity</code>.  For each error
   * encountered with that severity logged by the named <code>package</code>, the
   * severity of the error is reset to <code>targetSeverity</code>.
   <p>
   * <p>
 * The <em>severity override</em> mechanism in {@link XMLErrorLog} is intended to help
 * applications handle error conditions in ways that may be more convenient
 * for those applications.  It is possible to use the mechanism to override
 * the severity code of errors logged by libSBML, and even to disable error
 * logging completely.  An override stays in effect until the override is
 * changed again by the calling application.
   <p>
   * @param originalSeverity the severity code to match
   <p>
   * @param targetSeverity the severity code to use as the new severity
   <p>
   * @param package a string, the name of an SBML Level&nbsp;3 package
   * extension to use to narrow the search for errors.  A value of <code>'all'</code>
   * signifies to match against errors logged from any package; a value of a
   * package nickname such as <code>'comp'</code> signifies to limit consideration to
   * errors from just that package.  If no value is provided, <code>'all'</code> is the
   * default.
   <p>
   * 
</dl><dl class="docnote"><dt><b>Documentation note:</b></dt><dd>
The native C++ implementation of this method defines a default argument
value. In the documentation generated for different libSBML language
bindings, you may or may not see corresponding arguments in the method
declarations. For example, in Java and C#, a default argument is handled by
declaring two separate methods, with one of them having the argument and
the other one lacking the argument. However, the libSBML documentation will
be <em>identical</em> for both methods. Consequently, if you are reading
this and do not see an argument even though one is described, please look
for descriptions of other variants of this method near where this one
appears in the documentation.
</dd></dl>
 
   <p>
   * @see #isSeverityOverridden()
   * @see #getSeverityOverride()
   * @see #setSeverityOverride(int)
   * @see #unsetSeverityOverride()
   */ public
 void changeErrorSeverity(int originalSeverity, int targetSeverity) {
    libsbmlJNI.XMLErrorLog_changeErrorSeverity__SWIG_1(swigCPtr, this, originalSeverity, targetSeverity);
  }

}
