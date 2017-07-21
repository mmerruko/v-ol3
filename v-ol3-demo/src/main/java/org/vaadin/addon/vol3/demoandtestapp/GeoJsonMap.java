package org.vaadin.addon.vol3.demoandtestapp;

import org.vaadin.addon.vol3.OLMap;
import org.vaadin.addon.vol3.client.format.OLFeatureFormat;
import org.vaadin.addon.vol3.layer.OLVectorLayer;
import org.vaadin.addon.vol3.source.OLVectorSource;
import org.vaadin.addon.vol3.source.OLVectorSourceOptions;

/**
 * Bing Map view
 * Created by Martin Stypinski 22/03/2016
 */
public class GeoJsonMap extends BasicMap {

	@Override
	protected OLMap createMap() {
		OLMap map=super.createMap();
		// lets add some wfs features
		OLVectorSourceOptions vectorOptions=new OLVectorSourceOptions();
		// this is proxied by the TestServer
		vectorOptions.setUrl("https://raw.githubusercontent.com/varmais/maakunnat/master/kunnat.geojson");
		vectorOptions.setFormat(OLFeatureFormat.GEOJSON);
		OLVectorSource vectorSource=new OLVectorSource(vectorOptions);
		OLVectorLayer vectorLayer=new OLVectorLayer(vectorSource);
		vectorLayer.setLayerVisible(true);
		map.addLayer(vectorLayer);
		return map;
	}


}
