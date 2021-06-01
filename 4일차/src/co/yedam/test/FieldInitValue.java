package co.yedam.test;

import java.util.Arrays;

/*
 * 기본데이터형 8타입은 기본값은 0으로 초기화.
 * 참조변수(String, []) null로 초기화. 
 */
public class FieldInitValue {
	byte b;
	short s;
	int i;
	long l;
	float f;
	double d;
	boolean bool;
	char c;
	String Str;
	int[] arr;
	FieldInitValue(int intfield, double doublefield){
		i= intfield;
		d = doublefield;
		
		
		
	}

	
	@Override
	public String toString() {
		return "FieldInitValue [b=" + b + ", s=" + s + ", i=" + i + ", l=" + l + ", f=" + f + ", d=" + d + ", bool="
				+ bool + ", c=" + c + ", Str=" + Str + ", arr=" + Arrays.toString(arr) + "]";
	}
	
	
}
