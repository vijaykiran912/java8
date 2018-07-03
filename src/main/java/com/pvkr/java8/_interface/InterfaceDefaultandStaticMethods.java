package com.pvkr.java8._interface;

public class InterfaceDefaultandStaticMethods {
	public static void main(String[] args) {
		Vehicle vehicleImpl = new VehicleImpl();
		String overview = vehicleImpl.getOverview();

		System.out.println(overview);
	}
}
