/*
 * This file is part of mwat.
 *
 * mwat is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * mwat is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with mwat.  If not, see <http://www.gnu.org/licenses/>.
 */
package mpstyle.mwat.model.operation;

import org.apache.log4j.Logger;

/**
 * This class rappresents a task/operation to run, it provides a backbone for
 * the specialization classes.<br>
 * The only method to override is {@link #run() run}.<br>
 * To lunch an operation call the method {@link #start() start}.<br>
 */
public abstract class AbstractOperation
{
    private final Logger LOGGER=Logger.getLogger(AbstractOperation.class);
    
    /**
     * (Right now) The only task of this method is to encapsulate the call to the method
     * {@link #run() run} and print the throwed exceptions using log4j.
     */
    public final void start()
    {
        try
        {
            run();
        }
        catch (Exception ex)
        {
            LOGGER.error(ex);
        }
    }
    
    protected abstract void run();
}
