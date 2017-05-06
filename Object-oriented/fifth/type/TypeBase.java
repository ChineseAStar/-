package com.test.type;

public abstract class TypeBase {
	private String typeName;

	public TypeBase(String typeName){
		this.typeName=typeName;
	}
	
	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	@Override
	public String toString(){
		return this.typeName;
	}
}
