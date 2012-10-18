package oc.whfb.units.im;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class IMMount extends RuestkammerVater {

	OptionsUpgradeGruppe o1;

	boolean commander = false;

	public IMMount() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		// defaults[0] = erzlektor
		// defaults[1] = general
		// defaults[2] = meisterzauberer
		// defaults[3] = hauptmann
		// defaults[4] = Kampfzauberer
		// defaults[5] = Meistertechnikus
		// defaults[6] = Siegmarpriester
		// defaults[7] = Karl Franz
		

		this.commander = (defaults[0] || defaults[1]|| defaults[2]);
		
		if(defaults[7]){
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Gepanzertes Schlachtross"), 21));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Pegasus"), 50));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Todesklaue"), 225));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Imperialer Drache"), 320));
		}
		else{
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schlachtross"), this.commander ? 15 : 10));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Gepanzertes Schlachtross"), this.commander ? 21 : 14));		
			if(defaults[5])ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Mechanisches Ross"), 25));
			if(defaults[1]||defaults[2]||defaults[3])ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Pegasus"), 50));
			if(defaults[1])ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Greif"), 200));
			if(defaults[0])ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kriegsaltar"), 100));
		}

		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		setUeberschrift(BuildaHQ.translate("Reittier"));
		sizeSetzen(100, 100, 285, KAMMER_HOEHE + cnt + 10);
	}

	@Override
	public void switchEntry(String name, boolean aktiv) {
		if(o1.contains(name)) o1.setAktiv(name, aktiv);
	}

	@Override
	public void refreshen() {
		
	}
}
