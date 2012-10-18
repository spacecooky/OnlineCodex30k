package oc.wh40k.units.bt;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class BTSchwertbrueder extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o2;
	OptionsZaehlerGruppe o4;
	OptionsZaehlerGruppe o5;
	OptionsUpgradeGruppe o3;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	OptionsEinzelUpgrade oe3;
	OptionsEinzelZaehler oz1;
	RuestkammerStarter rkRazor;
	RuestkammerStarter rkRhino;
	RuestkammerStarter rkPod;

	public BTSchwertbrueder() {
		name = "Schwertbrüder";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Schwertbrüder", 5, 10, 19);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/BTSchwertbrueder.jpg"));

		seperator();

        ogE.addElement(new OptionsGruppeEintrag("Bolter", 0));
        ogE.addElement(new OptionsGruppeEintrag("BP + NKW", "Boltpistole + Nahkampfwaffe", 0));
        add(o5 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
        o5.setAnzahl(0, squad.getModelle());

        seperator();

		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Raktenwerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Multimelter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Laserkanone", 15));
		ogE.addElement(new OptionsGruppeEintrag("Plasmakanone", 20));
		ogE.addElement(new OptionsGruppeEintrag("Energieklauenpaar", 25));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 15));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 6));
		ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 15));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Kreuzzugssiegel", 0));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Fragmentgranaten", 0));
		add(oe3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Sprenggranaten", 0));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Rasender Angriff", 0));
		ogE.addElement(new OptionsGruppeEintrag("Gegenschlag", 0));
		ogE.addElement(new OptionsGruppeEintrag("Infiltratoren", 0));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

		seperator();

		add(oz1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "option", "Crux Terminatus", 0, 10));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Sturmschild & NKW", "Sturmschild & Nahkampfwaffe", 10));
		ogE.addElement(new OptionsGruppeEintrag("Sturmschild & Boltpistole", 10));
		ogE.addElement(new OptionsGruppeEintrag("Parierschild & Boltpistole", 5));
		add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 0));

		seperator();

		rkRazor = new RuestkammerStarter(ID, randAbstand, cnt, "BTRazorbackKammer", "Razorback");
		rkRazor.initKammer();
		add(rkRazor);

		seperator();

		rkRhino = new RuestkammerStarter(ID, randAbstand, cnt, "BTRhinoKammer", "Rhino");
		rkRhino.initKammer();
		add(rkRhino);

		seperator();

		rkPod = new RuestkammerStarter(ID, randAbstand, cnt, "BTDropPodKammer", "Landungskapsel");
		rkPod.initKammer(false);
		rkPod.setButtonText("Landungskapsel");
		rkPod.setSeperator(0);
		add(rkPod);

		complete();
	}

	@Override
	public void refreshen() {
		int count = squad.getModelle();

        o5.setMaxAnzahl(count - (o1.isSelected() ? 1 : 0) - (o2.isSelected() ? 1 : 0));
        o5.setLegal(o5.getAnzahl() == o5.getMaxAnzahl());

		oz1.setMaxAnzahl(count);
		o4.setMaxAnzahl(oz1.getAnzahl());
		o4.setAktiv(oz1.getAnzahl() > 0);

		oe1.setPreis(count * 2);
		oe2.setPreis(count * 1);
		oe3.setPreis(count * 2);

		boolean hasInfiltratoren = o3.isSelected("Infiltratoren");

		rkRazor.setAktiv(count <= 6 && !rkRhino.isSelected() && !rkPod.isSelected() && !hasInfiltratoren);
		rkRhino.setAktiv(!rkRazor.isSelected() && !rkPod.isSelected() && !hasInfiltratoren);
		rkPod.setAktiv(!rkRazor.isSelected() && !rkRhino.isSelected() && !hasInfiltratoren);

		rkRhino.getPanel().setLocation(
			(int) rkRazor.getPanel().getLocation().getX(),
			(int) rkRazor.getPanel().getLocation().getY() + rkRazor.getPanel().getSize().height + 5
		);
		rkPod.getPanel().setLocation(
			(int) rkRhino.getPanel().getLocation().getX(),
			(int) rkRhino.getPanel().getLocation().getY() + rkRhino.getPanel().getSize().height + 5
		);
	}

}
