package oc.wh40k.units.rh;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class RHTurretEmplacement extends Eintrag {

	
	OptionsZaehlerGruppe o1;

	public RHTurretEmplacement() {
		name = "Turret Emplacemet";
		grundkosten = 80;
		überschriftSetzen=true;

		

		add(ico = new oc.Picture("oc/wh40k/images/RHSentryGunBattery.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Heavy Flamer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Multi-laser", 5));
		ogE.addElement(new OptionsGruppeEintrag("Autocannon", 5));
		ogE.addElement(new OptionsGruppeEintrag("Missile launcher", 5));
		ogE.addElement(new OptionsGruppeEintrag("TL heavy bolters","Twin-linked heavy bolters", 10));
		ogE.addElement(new OptionsGruppeEintrag("Lascannon", 10));
		ogE.addElement(new OptionsGruppeEintrag("TL autocannons","Twin-linked autocannons", 15));
		ogE.addElement(new OptionsGruppeEintrag("Plasma cannon", 15));
		ogE.addElement(new OptionsGruppeEintrag("Inferno cannon", 15));
		ogE.addElement(new OptionsGruppeEintrag("Multi-melta", 15));
		ogE.addElement(new OptionsGruppeEintrag("Executioner plasma cannon", 40));
		ogE.addElement(new OptionsGruppeEintrag("Demolisher cannon", 35));
		ogE.addElement(new OptionsGruppeEintrag("Battle cannon", 35));
		ogE.addElement(new OptionsGruppeEintrag("Vanquisher cannon", 40));
		
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

		
		complete();
	}

	@Override
	public void refreshen() {
		o1.setLegal(o1.isSelected());
	}

}
