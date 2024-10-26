package br.edu.ifsp.dsw1.ex1.strategy;

public class FahrenheitConverter implements TemperatureConverter {
	@Override
	public double convert(double temperature) {
		return 1.8 * temperature + 32;
	}
}
