package br.edu.ifsp.dsw1.ex1.strategy;

public class CelsiusConverter implements TemperatureConverter {
	@Override
	public double convert(double temperature) {
		return (temperature - 32) / 1.8;
	}
}
