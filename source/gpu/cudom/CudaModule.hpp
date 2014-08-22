// == PREAMBLE ================================================

// * Licensed under the Apache License, Version 2.0; see README

// == FILEDOC =================================================

/** @file CudaModule.h
  * @author JKM
  * @date 08/21/2014
  * @copyright Apache License, Version 2.0
  * @brief DOM for single CUDA file
**/

#ifndef rrGPU_CUDADOM_CudaModule_H
#define rrGPU_CUDADOM_CudaModule_H

// == MACROS ==================================================

#if !defined(__cplusplus)
#   error "You are including a .hpp in non-C++ code"
#endif

#if (__cplusplus < 201103L) && !defined(_MSC_VER)
#   error "This file requires C++11 support in order to compile"
#endif

// == INCLUDES ================================================

# include <gpu/bdom/Structures.hpp>

// == CODE ====================================================


namespace rr
{

namespace rrgpu
{

namespace dom
{

/**
 * @author JKM
 * @brief CUDA function
 */
class CudaFunction : public Function {
public:
    using Function::Function;
    virtual void serialize(std::ostream& os) const;
};

/**
 * @author JKM
 * @brief CUDA function
 */
class CudaKernel : public CudaFunction {
public:
    using CudaFunction::CudaFunction;

    ~CudaKernel() {}

    virtual void serialize(std::ostream& os) const;
};
typedef std::unique_ptr<CudaKernel> CudaKernelPtr;

/**
 * @author JKM
 * @brief CUDA module
 */
class CudaModule : public Module {
public:
    typedef std::unique_ptr<CudaFunction> CudaFunctionPtr;

    /// Serialize to a .cu source file
    virtual void serialize(std::ostream& os) const;

    void addFunction(CudaFunction&& f) {
        func_.emplace_back(new CudaFunction(std::move(f)));
    }

    void addFunction(CudaFunctionPtr&& f) {
        func_.emplace_back(std::move(f));
    }
};

} // namespace dom

} // namespace rrgpu

} // namespace rr

#endif // header guard