package oc.wh30k.units.or;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class ORTransporterKammer  extends RuestkammerVater {

	OptionsUpgradeGruppe o1, o2, o3;

	public ORTransporterKammer () {
            grundkosten = 195;
	}

	public void initButtons(boolean... defaults) {


		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Twin-linked heavy bolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Twin-linked phase-plasma fusil", "Twin-linked phase-plasma fusil", 10));
		ogE.addElement(new OptionsGruppeEintrag("Volkite Culvarin", 15));
		ogE.addElement(new OptionsGruppeEintrag("Multi-melta", 15));
		ogE.addElement(new OptionsGruppeEintrag("Lascannon", 20));
		ogE.addElement(new OptionsGruppeEintrag("Graviton cannon", 25));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("2 Lascannons", "2 Lascannon sponsons", 0));
		ogE.addElement(new OptionsGruppeEintrag("2 Quad heavy bolters", "2 Quad heavy bolter sponsons", 0));
		ogE.addElement(new OptionsGruppeEintrag("2 Flamestorm cannons", "2 Flamestorm cannon sponsons", 20));
		ogE.addElement(new OptionsGruppeEintrag("2 Twin-linked lascannons", "2 Twin-linked lascannon sponsons", 40));
		ogE.addElement(new OptionsGruppeEintrag("2 Twin-linked multi-meltas", "2 Twin-linked Multi-melta sponsons", 40));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Hunter-killer missile", 10));
		ogE.addElement(new OptionsGruppeEintrag("Dozer blade", 5));
		ogE.addElement(new OptionsGruppeEintrag("Auxiliary drive", 10));
		ogE.addElement(new OptionsGruppeEintrag("Extra armour", 10));
		ogE.addElement(new OptionsGruppeEintrag("Armoured ceramite", 20));
		ogE.addElement(new OptionsGruppeEintrag("Flare shield", 25));
		ogE.addElement(new OptionsGruppeEintrag("Frag assault launchers", 10));
		ogE.addElement(new OptionsGruppeEintrag("Explorator Augury Web", 50));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 8));
		
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		if (!o1.isSelected()) o1.setSelected(0, true);
		if (!o2.isSelected()) o2.setSelected(0, true);
		
	}
        
}