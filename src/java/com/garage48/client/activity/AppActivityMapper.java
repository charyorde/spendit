package com.garage48.client.activity;

import com.garage48.client.ClientFactory;
import com.garage48.client.place.AddExpensePlace;
import com.garage48.client.place.HomePlace;
import com.garage48.client.place.HowItWorksPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class AppActivityMapper implements ActivityMapper {


        private ClientFactory clientFactory;

	/**
	 * AppActivityMapper associates each Place with its corresponding
	 * {@link Activity}
	 * 
	 * @param clientFactory
	 *            Factory to be passed to activities
	 */
	/*public AppActivityMapper(MainPresenter presenter) {
		super();
		this.presenter = presenter;
	}*/

        public AppActivityMapper(ClientFactory clientFactory) {
		super();
		this.clientFactory = clientFactory;
                //this.presenter = presenter;
	}

	/**
	 * Map each Place to its corresponding Activity. This would be a great use
	 * for GIN.
	 */
	@Override
	public Activity getActivity(Place place) {
		// This is begging for GIN
                if(place instanceof HomePlace)
                    return new HomeActivity((HomePlace) place, clientFactory);
		if (place instanceof HowItWorksPlace)
			return new HowItWorksActivity((HowItWorksPlace) place, clientFactory);
                if (place instanceof AddExpensePlace)
			return new AddExpenseActivity((AddExpensePlace) place, clientFactory);
                else
		return null;
	}

}
