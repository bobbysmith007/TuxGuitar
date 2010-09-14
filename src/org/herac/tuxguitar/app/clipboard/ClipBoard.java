/*
 * Created on 09-dic-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.herac.tuxguitar.app.clipboard;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;



/**
 * @author julian
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ClipBoard{
	public ClipBoard(){}
	public void addTransferable(final Transferable transferable){
		Clipboard sysclip = java.awt.Toolkit.getDefaultToolkit().getSystemClipboard();
		sysclip.setContents(transferable, null);
	}
	
	public Transferable getTransferable(){
		Clipboard sysclip = java.awt.Toolkit.getDefaultToolkit().getSystemClipboard();
		try {
			return (Transferable) java.awt.Toolkit.getDefaultToolkit().getSystemClipboard().getData(MeasureTransferable.Measure);
		} 
		catch (UnsupportedFlavorException e){ e.printStackTrace(); }	// TODO Auto-generated catch block
		catch (IOException e){ e.printStackTrace(); }// TODO Auto-generated catch block
		return null;
	}
	
	public void insertTransfer() throws CannotInsertTransferException{
		if(this.isEmpty()){
			throw new CannotInsertTransferException();
		}
		this.getTransferable().insertTransfer();
	}
	
	public boolean isEmpty(){
		return (this.getTransferable() == null);
	}
}