package oc.wh40k.units.ba;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class BAScriptor extends Eintrag {

	OptionsUpgradeGruppe o1;
	OptionsEinzelUpgrade termi;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe t1;
    OptionsUpgradeGruppe psi;

	public BAScriptor() {
		name = "Scriptor";
		grundkosten = 100;

		BuildaHQ.addToInformationVector("BAHQ", 1);

		add(ico = new oc.Picture("oc/wh40k/images/BAScriptor.jpg"));
		
		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Epistolarius", 50));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 3));
		ogE.addElement(new OptionsGruppeEintrag("Flammenpistole", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flamer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma-Pistole", 15));
		ogE.addElement(new OptionsGruppeEintrag("Infernus-Pistole", 15));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(termi = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Terminator-Rüstung", 25));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flamer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Sturmschild", 20));
		add(t1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sprungmodul", 25));
		ogE.addElement(new OptionsGruppeEintrag("Space Marine Bike", 35));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Blutspeer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Macht der Helden", 0));
		ogE.addElement(new OptionsGruppeEintrag("Schild des Sanguinius", 0));
		ogE.addElement(new OptionsGruppeEintrag("Schmetterschlag", 0));
		ogE.addElement(new OptionsGruppeEintrag("Schwert des Sanguinius", 0));
		ogE.addElement(new OptionsGruppeEintrag("Schrecken d. Finsternis", "Schrecken der Finsternis", 0));
		ogE.addElement(new OptionsGruppeEintrag("Schwingen d. Sanguinius", "Schwingen des Sanguinius", 0));
		ogE.addElement(new OptionsGruppeEintrag("Seelenfesseln", 0));
		ogE.addElement(new OptionsGruppeEintrag("Siedendes Blut", 0));
		ogE.addElement(new OptionsGruppeEintrag("Zorn entfesseln", 0));
		add(psi = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 2));

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

	@Override
	public void deleteYourself() {
		BuildaHQ.addToInformationVector("BAHQ", -1);
		super.deleteYourself();
	}

}
