package org.herac.tuxguitar.song.models;

import org.herac.tuxguitar.song.factory.TGFactory;

public class TGStroke implements java.io.Serializable  {
	
	public static final int STROKE_NONE = 0;
	public static final int STROKE_UP = 1;
	public static final int STROKE_DOWN = -1;
	
	private int direction;
	private int value;
	
	public TGStroke(){
		this.direction = STROKE_NONE;
	}

	public int getDirection() {
		return this.direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getIncrementTime( TGBeat beat ){
		long duration = 0;
		if( this.value > 0 ){
			for(int v = 0; v < beat.countVoices(); v ++){
				TGVoice voice = beat.getVoice( v );
				if( !voice.isEmpty() ){
					long currentDuration = voice.getDuration().getTime();
					if(duration == 0 || currentDuration < duration){
						duration = ( currentDuration <= TGDuration.QUARTER_TIME ? currentDuration : TGDuration.QUARTER_TIME );
					}
				}
			}
			if( duration > 0 ){
				return Math.round( ( ( duration / 8.0f ) * ( 4.0f / this.value ) ) );
			}
		}
		return 0;
	}
	
	public TGStroke clone(TGFactory factory){
		TGStroke stroke = factory.newStroke();
		copy(stroke);
		return stroke;
	}
	
	public void copy(TGStroke stroke){
		stroke.setValue(getValue());
		stroke.setDirection(getDirection());
	}
}
