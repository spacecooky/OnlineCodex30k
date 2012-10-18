package oc.wh40k.units.el;

import oc.BuildaHQ;
import oc.Eintrag;

public class ELEldradUlthran extends Eintrag {

	public ELEldradUlthran() {
		name = "Eldrad Ulthran";
		grundkosten = 210;

		add(ico = new oc.Picture("oc/wh40k/images/ELEldradUlthran.jpg"));
		

		complete();
	}

	//@OVERRIDE
	public void refreshen() {
        setUnikat(true);
        
        if(BuildaHQ.getCountFromInformationVector("ELBelAnnath")>0){
        	setFehlermeldung("Keine Runenpropethen!");
        }else{
        	setFehlermeldung("");
        }
	}
	
}
