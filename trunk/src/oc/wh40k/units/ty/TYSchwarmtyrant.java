package oc.wh40k.units.ty;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class TYSchwarmtyrant extends Eintrag {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;
	OptionsUpgradeGruppe o4;

	public TYSchwarmtyrant() {
		name = "Schwarmtyrant";
		grundkosten = 170;

		BuildaHQ.addToInformationVector("TYTyrant", 1);

		add(ico = new oc.Picture("oc/wh40k/images/TYSchwarmtyrantFuss.jpg"));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Peitsche & Hornschwert", "Tentakelpeitsche und Hornschwert", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sensenklauen", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Säurespucker", "Synchronisierte Säurespucker", 15));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Neuralfresser", "Synchronisierte Neuralfresser mit Hirnwürmern", 15));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected(0, true);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sensenklauen", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Säurespucker", "Synchronisierte Säurespucker", 15));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Neuralfresser", "Synchronisierte Neuralfresser mit Hirnwürmern", 15));
		ogE.addElement(new OptionsGruppeEintrag("Dornenwürgerkanone", 20));
		ogE.addElement(new OptionsGruppeEintrag("Schwere Biozidkanone", 25));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o2.setSelected(0, true);

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Alter Widersacher", 25));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Taktischer Instinkt", 25));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Unbeschr. Schrecken", "Unbeschreiblicher Schrecken", 25));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Adrenalindrüsen", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Toxinkammern", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Säureblut", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Injektor", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Toxisches Miasma", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Regeneration", 20));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Thorax: Schockmaden", "Thoraxschwarm mit Schockmaden", 25));
		ogE.addElement(new OptionsGruppeEintrag("Thorax: Sauglarven", "Thoraxschwarm mit Sauglarven", 25));
		ogE.addElement(new OptionsGruppeEintrag("Thorax: Splitterschalenkäfer", "Thoraxschwarm mit Splitterschalenkäfer", 25));
		ogE.addElement(new OptionsGruppeEintrag("Gepanzerte Schale", 40));
		ogE.addElement(new OptionsGruppeEintrag("Flügel", 60));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Das Grauen", 0));
		ogE.addElement(new OptionsGruppeEintrag("Lebensraub", 0));
		ogE.addElement(new OptionsGruppeEintrag("Mentaler Schrei", 0));
		ogE.addElement(new OptionsGruppeEintrag("Nervenschock", 0));
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 2));

		complete();
	}

	@Override
	public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();

		if(o3.isSelected("Flügel")) {
			ico.setIcon("oc/wh40k/images/TYSchwarmtyrant.jpg");
		} else {
			ico.setIcon("oc/wh40k/images/TYSchwarmtyrantFuss.jpg");
		}
	}

	@Override
	public void deleteYourself() {
		BuildaHQ.addToInformationVector("TYTyrant", -1);
	}

}
