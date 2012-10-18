package oc.wh40k.units.tl;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class TLLegionAuxilia extends Eintrag {

	AnzahlPanel auxiliaries;
	
	OptionsEinzelUpgrade prefect;
	OptionsZaehlerGruppe o2;
	OptionsZaehlerGruppe o3;

	public TLLegionAuxilia() {
		
	
		add(ico = new oc.Picture("oc/wh40k/images/TLLegionAuxilia.jpg"));
		

		auxiliaries = new AnzahlPanel(ID, randAbstand, cnt, "Auxiliaries", 20, 40, 3);
		add(auxiliaries);
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Flamer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Grenade Launcher", 5));
		ogE.addElement(new OptionsGruppeEintrag("Heavy Stubber", 10));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
		
		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Frag grenades", 10));
		
		seperator();
		
		add(prefect = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Prefect", 10));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Shotgun", 0));
		ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 5));
		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 1));

		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Krak grenades", 2));

		complete();
	}

	// @OVERRIDE
	public void refreshen() {
		prefect.setSelected(true);
		o2.setMaxAnzahl(auxiliaries.getModelle()/10);
		
	}

}
