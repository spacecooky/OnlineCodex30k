package oc.wh40k.units.bt;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class BTTechmarine extends Eintrag {

	OptionsZaehlerGruppe o1;
	RuestkammerStarter rkWargear;
	RuestkammerStarter rkRazor;
	RuestkammerStarter rkRhino;
	RuestkammerStarter rkRaider;

	public BTTechmarine() {
		name = "Techmarine";
		grundkosten = 70;

		add(ico = new oc.Picture("oc/wh40k/images/BTTechmarine.jpg"));

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Servoharnisch", 35));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Plasmakanonen Servitor", "Waffenservitor mit Plasmakanone", 45));
		ogE.addElement(new OptionsGruppeEintrag("Multimelter Servitor", "Waffenservitor mit Multimelter", 35));
		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter Servitor", "Waffenservitor mit schwerem Bolter", 25));
		ogE.addElement(new OptionsGruppeEintrag("Kampfservitor", 25));
		ogE.addElement(new OptionsGruppeEintrag("Techservitor", 10));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

		o1.setButtonMaxAnzahl("Waffenservitor mit Plasmakanone", 1);

		seperator();

		rkWargear = new RuestkammerStarter(ID, randAbstand, cnt, "BTArmoury", "");
		rkWargear.initKammer(true, false, false);
		rkWargear.setButtonText("Ausrüstung");
		add(rkWargear);

		seperator();

		rkRazor = new RuestkammerStarter(ID, randAbstand, cnt, "BTRazorbackKammer", "Razorback");
		rkRazor.initKammer();
		add(rkRazor);

		seperator();

		rkRhino = new RuestkammerStarter(ID, randAbstand, cnt, "BTRhinoKammer", "Rhino");
		rkRhino.initKammer();
		add(rkRhino);

		seperator();

		rkRaider = new RuestkammerStarter(ID, randAbstand, cnt, "BTLandRaiderCrusaderKammer", "Land Raider Crusader");
		rkRaider.initKammer();
		add(rkRaider);
		
		complete();
	}

	@Override
	public void refreshen() {

		rkRazor.setAktiv(!rkRhino.isSelected() && !rkRaider.isSelected());
		rkRhino.setAktiv(!rkRazor.isSelected() && !rkRaider.isSelected());
		rkRaider.setAktiv(!rkRhino.isSelected() && !rkRazor.isSelected());

		rkRazor.getPanel().setLocation(
			(int) rkWargear.getPanel().getLocation().getX(),
			(int) rkWargear.getPanel().getLocation().getY() + rkWargear.getPanel().getSize().height + 5
		);
		rkRhino.getPanel().setLocation(
			(int) rkRazor.getPanel().getLocation().getX(),
			(int) rkRazor.getPanel().getLocation().getY() + rkRazor.getPanel().getSize().height + 5
		);
		rkRaider.getPanel().setLocation(
			(int) rkRhino.getPanel().getLocation().getX(),
			(int) rkRhino.getPanel().getLocation().getY() + rkRhino.getPanel().getSize().height + 5
		);
	}

}
