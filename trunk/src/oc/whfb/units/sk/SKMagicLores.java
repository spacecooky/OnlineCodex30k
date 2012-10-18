package oc.whfb.units.sk;

import java.util.Vector;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class SKMagicLores extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	
	boolean isWarlock = false;
	boolean isPlague = false;
	boolean isBoth = false;
	
	public SKMagicLores() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		
		isWarlock = defaults[0];
		isPlague  = defaults[1];
		isBoth 	  = isWarlock && isPlague;
			
		if ( isBoth ){
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre der Seuche")));
			add(o1 = new OptionsUpgradeGruppe( ID, randAbstand, cnt, "", ogE, false ));
			o1.setSelected(0, true);
			
			seperator(35);
			
			ogE = new Vector<OptionsGruppeEintrag>();
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Untergangs")));
			add(o2 = new OptionsUpgradeGruppe( ID, randAbstand, cnt, "", ogE, false ));
			o2.setSelected(0, true);
		
		} else {		
			if ( isPlague ) {//Seuchenmoench & Lord Skrolk
				ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre der Seuche")));	
			} else if ( isWarlock ) {//Warlock & Ikit
				ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Untergangs")));	
			} // Grauer Prophet, Rattendaemon & Thanquol kennen beide Lehren
			
			add(o1 = new OptionsUpgradeGruppe( ID, randAbstand, cnt, "", ogE, false ));
		}
		setHeadline(o1, BuildaHQ.translate("Lehren der Magie"));
		setUeberschrift(BuildaHQ.translate("Lehren der Magie"));
		sizeSetzen(100, 100, 285, KAMMER_HOEHE + cnt + 10);
	}

	@Override
	public void refreshen() {
		setButtonState(BuildaHQ.noErrors);
		if ( !isBoth ) {
			o1.alwaysSelected();
		}
	}

}
