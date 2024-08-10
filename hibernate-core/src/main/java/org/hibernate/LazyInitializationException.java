/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate;

import org.hibernate.internal.CoreMessageLogger;

import org.jboss.logging.Logger;

import java.lang.invoke.MethodHandles;

/**
 * Indicates an attempt to access unfetched data outside the context
 * of an open stateful {@link Session}.
 * <p>
 * For example, this exception occurs when an uninitialized proxy or
 * collection is accessed after the session was closed.
 *
 * @see Hibernate#initialize(Object)
 * @see Hibernate#isInitialized(Object)
 * @author Gavin King
 */
public class LazyInitializationException extends HibernateException {

	private static final CoreMessageLogger LOG = Logger.getMessageLogger(
			MethodHandles.lookup(),
			CoreMessageLogger.class,
			LazyInitializationException.class.getName()
	);

	/**
	 * Constructs a {@code LazyInitializationException} using the given message.
	 *
	 * @param message A message explaining the exception condition
	 */
	public LazyInitializationException(String message) {
		super( message );
		LOG.trace( message, this );
	}

}
