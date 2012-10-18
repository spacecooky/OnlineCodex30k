package oc.whfb.units.de;

import java.util.Vector;

import oc.BuildaHQ;
import oc.CommonMagicItems;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppeUnique;
import oc.RuestkammerVater;

public class DEMorathiItems extends RuestkammerVater {

	OptionsUpgradeGruppeUnique o1;
	OptionsUpgradeGruppeUnique o2;

	public DEMorathiItems() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Todesmaske"), 50));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Die Fänge der Hydra"), 40));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Mitternachtskristall"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schwarzes Drachenei"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Stärketrank"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Alptraumjuwel"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Das leitende Auge"), 25));
		
		CommonMagicItems.addCommonEnchanted(ogE, 100);
		
		add(o1 = new OptionsUpgradeGruppeUnique(ID, randAbstand, cnt, "", ogE, true));
		setHeadline(o1, BuildaHQ.translate("Verzauberte Gegenstände"));

		seperator();
		
		cnt = randAbstand;
		
		ogE = new Vector<OptionsGruppeEintrag>();
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schwarzer Stab"), 55));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zauberhomunkulus"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Sternenlichtmantel"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Opferdolch"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Buch des Furion"), 15));
		
		CommonMagicItems.addCommonArcane(ogE, 100, 35, 20, 25);
		
		add(o2 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "", ogE, true));
		
		setHeadline(o2, BuildaHQ.translate("Arkane Artefakte"));
		setUeberschrift(BuildaHQ.translate("Magische Gegenstände"));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
		
	}

}
