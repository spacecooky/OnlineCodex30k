package oc.wh40k.units.sm;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OnlineCodex;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class SMSpaceMarineScriptor extends Eintrag {

	OptionsUpgradeGruppe o1;
	OptionsEinzelUpgrade termi;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe t1;
    OptionsUpgradeGruppe psi;

	public SMSpaceMarineScriptor() {
		name = "Space Marine Scriptor";
		grundkosten = 100;

		add(ico = new oc.Picture("oc/wh40k/images/SMSpaceMarineScriptor.jpg"));
		
		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Epistolarius", 50));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 3));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flamer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 15));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Plasma-Pistole", 15));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sprungmodul", 25));
		if(!OnlineCodex.getInstance().isCurrentArmy(oc.wh40k.armies.VOLKSiegeVanguardIA10.class)) {
                    ogE.addElement(new OptionsGruppeEintrag("Space Marine Bike", 35));
                }
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(termi = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Terminator-Rüstung", 25));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flamer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Sturmschild", 15));
		add(t1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Schmetterschlag", 0));
		ogE.addElement(new OptionsGruppeEintrag("Psi-Schild", 0));
		ogE.addElement(new OptionsGruppeEintrag("Maschinenfluch", 0));
		ogE.addElement(new OptionsGruppeEintrag("Beschleunigung", 0));
		ogE.addElement(new OptionsGruppeEintrag("Null-Zone", 0));
		ogE.addElement(new OptionsGruppeEintrag("Avatar der Sühne", 0));
		ogE.addElement(new OptionsGruppeEintrag("Macht der Alten", 0));
		ogE.addElement(new OptionsGruppeEintrag("Tor zur Unendlichkeit", 0));
		ogE.addElement(new OptionsGruppeEintrag("Vortex der Verdammnis", 0));
		add(psi = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 2));
        
        psi.setSelected(0, true);
        psi.setSelected(1, true);

		complete();
	}

	@Override
	public void refreshen() {
		o1.setAktiv(!termi.isSelected());
		o2.setAktiv(!termi.isSelected());
		t1.setAktiv(termi.isSelected());
        
        if(psi.getAnzahl() < 2) {
            psi.setLegal(false);
            setFehlermeldung("Wähle 2 Psikräfte");
        } else {
            psi.setLegal(true);
            setFehlermeldung("");
        }
	}

}
