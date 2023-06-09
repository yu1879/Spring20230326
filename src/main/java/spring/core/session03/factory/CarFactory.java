package spring.core.session03.factory;

import java.util.Random;

import org.springframework.beans.factory.FactoryBean;

import spring.core.session03.bean.Car;

public class CarFactory implements FactoryBean<Car> {

	@Override
	public Car getObject() throws Exception {

		Random random = new Random();
		int price = random.nextInt(300_0000);

		return new Car("BMW", price);
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return Car.class;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return true;
	}

}
