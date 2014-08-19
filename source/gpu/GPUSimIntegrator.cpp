#pragma hdrstop
#include "GPUSimIntegrator.h"
#include "GPUSimException.h"
#include "rrExecutableModel.h"
#include "rrException.h"
#include "rrLogger.h"
#include "rrStringUtils.h"
#include "rrException.h"
#include "rrUtils.h"

#include <cvode/cvode.h>
#include <cvode/cvode_dense.h>
#include <nvector/nvector_serial.h>
#include <cstring>
#include <iomanip>
#include <math.h>
#include <map>
#include <algorithm>
#include <assert.h>
#include <Poco/Logger.h>

void launchKern();


using namespace std;
namespace rr
{
namespace rrgpu
{

void GPUSimIntegrator::setListener(IntegratorListenerPtr p)
{
    throw_gpusim_exception("not supported");
}

IntegratorListenerPtr GPUSimIntegrator::getListener()
{
    throw_gpusim_exception("not supported");
}

GPUSimIntegrator::GPUSimIntegrator(ExecutableModel *aModel, const SimulateOptions* options)
{
    Log(Logger::LOG_INFORMATION) << "creating GPUSimIntegrator";
}

GPUSimIntegrator::~GPUSimIntegrator()
{
}

void GPUSimIntegrator::setSimulateOptions(const SimulateOptions* o)
{
}

double GPUSimIntegrator::integrate(double timeStart, double hstep)
{
    Log(lDebug3)<<"---------------------------------------------------";
    Log(lDebug3)<<"--- O N E     S T E P      ( "<<mOneStepCount<< " ) ";
    Log(lDebug3)<<"---------------------------------------------------";

    mOneStepCount++;

    launchKern();
    throw_gpusim_exception("not supported");
}

void GPUSimIntegrator::restart(double time)
{
}

_xmlNode* GPUSimIntegrator::createConfigNode()
{
    throw_gpusim_exception("not supported");
}

void GPUSimIntegrator::loadConfig(const _xmlDoc* doc)
{
    throw_gpusim_exception("not supported");
}

void GPUSimIntegrator::setValue(const std::string& key, const rr::Variant& value)
{
    throw_gpusim_exception("not supported");
}

Variant GPUSimIntegrator::getValue(const std::string& key) const
{
    throw_gpusim_exception("not supported");
}

bool GPUSimIntegrator::hasKey(const std::string& key) const
{
    throw_gpusim_exception("not supported");
}

int GPUSimIntegrator::deleteValue(const std::string& key)
{
    throw_gpusim_exception("not supported");
}

std::vector<std::string> GPUSimIntegrator::getKeys() const
{
    throw_gpusim_exception("not supported");
}


std::string GPUSimIntegrator::toString() const
{
    std::stringstream ss;
    ss << "< roadrunner.GPUSimIntegrator() >\n";

    return ss.str();
}

std::string GPUSimIntegrator::toRepr() const
{
    std::stringstream ss;
    ss << "< roadrunner.GPUSimIntegrator() >\n";
    return ss.str();
}

std::string GPUSimIntegrator::getName() const
{
    return "gpusim";
}

Integrator* CreateGPUSimIntegrator(ExecutableModel* oModel, const SimulateOptions* options) {
    return new GPUSimIntegrator(oModel, options);
}

} // namespace rrgpu

} // namespace rr
