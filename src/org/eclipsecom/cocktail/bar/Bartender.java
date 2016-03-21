package org.eclipsecom.cocktail.bar;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkListener;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;
import org.eclipsecom.cocktail.bar.Waitress;
public class Bartender {

	public void mixDrink(Drink drink, Ingredients incredients) {
		incredients.getIngredients();
		drink.shake();
		notifyWaitrss(drink);
		//throw new IllegalStateException();
	}

	private void notifyWaitrss(Drink drink) {
		//i don't want to inject bundle context as constructor argument
		//i wan't to get at runtime
		//returns bundle object of bartender class
		Bundle bundle =FrameworkUtil.getBundle(Bartender.class);
		if (bundle !=null){
			BundleContext bundleContext = bundle.getBundleContext();
		    ServiceReference reference = bundleContext.getServiceReference(Waitress.class.getName());
		    Waitress waitress = (Waitress)bundleContext.getService(reference);
			waitress.serveDrink(drink);
		}
		
	}
  public Bundle getBundle(){
	 return FrameworkUtil.getBundle(Bartender.class);
 }

}
