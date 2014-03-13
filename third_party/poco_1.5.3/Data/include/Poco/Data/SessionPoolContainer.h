//
// SessionPoolContainer.h
//
// $Id: //poco/Main/Data/include/Poco/Data/SessionPoolContainer.h#4 $
//
// Library: Data
// Package: SessionPoolContainering
// Module:  SessionPoolContainer
//
// Definition of the SessionPoolContainer class.
//
// Copyright (c) 2006, Applied Informatics Software Engineering GmbH.
// and Contributors.
//
// Permission is hereby granted, free of charge, to any person or organization
// obtaining a copy of the software and accompanying documentation covered by
// this license (the "Software") to use, reproduce, display, distribute,
// execute, and transmit the Software, and to prepare derivative works of the
// Software, and to permit third-parties to whom the Software is furnished to
// do so, all subject to the following:
// 
// The copyright notices in the Software and this entire statement, including
// the above license grant, this restriction and the following disclaimer,
// must be included in all copies of the Software, in whole or in part, and
// all derivative works of the Software, unless such copies or derivative
// works are solely in the form of machine-executable object code generated by
// a source language processor.
// 
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE, TITLE AND NON-INFRINGEMENT. IN NO EVENT
// SHALL THE COPYRIGHT HOLDERS OR ANYONE DISTRIBUTING THE SOFTWARE BE LIABLE
// FOR ANY DAMAGES OR OTHER LIABILITY, WHETHER IN CONTRACT, TORT OR OTHERWISE,
// ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
// DEALINGS IN THE SOFTWARE.
//


#ifndef Data_SessionPoolContainer_INCLUDED
#define Data_SessionPoolContainer_INCLUDED


#include "Poco/Data/Data.h"
#include "Poco/Data/Session.h"
#include "Poco/Data/SessionPool.h"
#include "Poco/String.h"
#include "Poco/Mutex.h"


namespace Poco {
namespace Data {


class Data_API SessionPoolContainer
	/// This class implements container of session pools.
{
public:
	SessionPoolContainer();
		/// Creates the SessionPoolContainer for sessions with the given session parameters.

	~SessionPoolContainer();
		/// Destroys the SessionPoolContainer.
	
	void add(SessionPool* pPool);
		/// Adds existing session pool to the container.
		/// Throws SessionPoolExistsException if pool already exists.

	Session add(const std::string& sessionKey, 
		const std::string& connectionString,
		int minSessions = 1, 
		int maxSessions = 32, 
		int idleTime = 60);
		/// Adds a new session pool to the container and returns a Session from
		/// newly created pool. If pool already exists, request to add is silently
		/// ignored and session is returned from the existing pool.

	bool has(const std::string& name) const;
		/// Returns true if the requested name exists, false otherwise.

	bool isActive(const std::string& sessionKey,
		const std::string& connectionString = "") const;
		/// Returns true if the session is active (i.e. not shut down).
		/// If connectionString is empty string, sessionKey must be a 
		/// fully qualified session name as registered with the pool
		/// container.

	Session get(const std::string& name);
		/// Returns the requested Session.
		/// Throws NotFoundException if session is not found.

	SessionPool& getPool(const std::string& name);
		/// Returns a SessionPool reference.
		/// Throws NotFoundException if session is not found.

	void remove(const std::string& name);
		/// Removes a SessionPool.
		
	int count() const;
		/// Returns the number of session pols in the container.

	void shutdown();
		/// Shuts down all the held pools.

private:
	typedef std::map<std::string, AutoPtr<SessionPool>, Poco::CILess> SessionPoolMap;

	SessionPoolContainer(const SessionPoolContainer&);
	SessionPoolContainer& operator = (const SessionPoolContainer&);
		
	SessionPoolMap  _sessionPools;
	Poco::FastMutex _mutex;
};


inline bool SessionPoolContainer::has(const std::string& name) const
{
	return _sessionPools.find(name) != _sessionPools.end();
}


inline void SessionPoolContainer::remove(const std::string& name)
{
	_sessionPools.erase(name);
}


inline int SessionPoolContainer::count() const
{
	return static_cast<int>(_sessionPools.size());
}


} } // namespace Poco::Data


#endif // Data_SessionPoolContainer_INCLUDED
