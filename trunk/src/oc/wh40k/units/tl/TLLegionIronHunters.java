package oc.wh40k.units.tl;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class TLLegionIronHunters extends Eintrag {

	AnzahlPanel hunters;
	
	OptionsEinzelUpgrade huntmaster;
	OptionsZaehlerGruppe o2;
	OptionsZaehlerGruppe o3;

	public TLLegionIronHunters() {
		
	
		add(ico = new oc.Picture("oc/wh40k/images/TLLegionIronHunters.jpg"));
		

		hunters = new AnzahlPanel(ID, randAbstand, cnt, "Iron Hunters", 5, 10, 25);
		add(hunters);
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Flamer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Meltagun", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma gun", 15));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();
		
		add(huntmaster = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Huntmaster", 30));
		
		seperator();
		ogE.addElement(new OptionsGruppeEintrag("Combi-melta", 10));
		ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", 10));
		ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 15));
		ogE.addElement(new OptionsGruppeEintrag("Power fist", 25));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 1));

		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Melta bombs", 5));

		complete();
	}

	// @OVERRIDE
	public void refreshen() {
		huntmaster.setSelected(true);
		o2.setMaxAnzahl(hunters.getModelle()/5);
	}

}
