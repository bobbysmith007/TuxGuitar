/*
 * Created on 09-dic-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.herac.tuxguitar.app.clipboard;

/**
 * @author julian
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface Transferable extends java.awt.datatransfer.Transferable {
	
	public void insertTransfer()throws CannotInsertTransferException;
	
}
