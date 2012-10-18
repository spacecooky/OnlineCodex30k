package oc.wh40k.units.ig;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class IGLordKommissar extends Eintrag {

	OptionsZaehlerGruppe o1;
	RuestkammerStarter rkTransport;

	public IGLordKommissar() {
		name = "Lord-Kommissar";
		grundkosten = 70;

		add(ico = new oc.Picture("oc/wh40k/images/IGLordCommissar.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 10));
		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 10));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 15));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand + 10, cnt, "option", "Melterbomben", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand + 10, cnt, "option", "Plattenrüstung", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand + 10, cnt, "option", "Tarnmantel", 10));

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "IGChimaere", "Chimäre");
		rkTransport.initKammer(true);
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
	}

}
