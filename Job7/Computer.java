package ru.mera.korsakovkirill.postman;

public abstract class Computer extends AbstractItem {

	public int hdd;
	public int ram;
	public int CPU;

	public int getHDD() {
		return hdd;
	}

	public int getRam() {
		return ram;
	}

	public int getCPU() {
		return CPU;
	}
	
	public int getSumHDD() {
		int sumHDD = getHDD() * getQuantity();
		return sumHDD;
	}

}
