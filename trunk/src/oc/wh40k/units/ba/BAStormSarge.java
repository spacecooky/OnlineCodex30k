package oc.wh40k.units.ba;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class BAStormSarge extends RuestkammerVater {

	OptionsZaehlerGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;

	boolean expugnator = false;

	public BAStormSarge() {
		grundkosten = 10;
	}

	@Override
	public void initButtons(boolean... defaults) {
		if(defaults[0]) expugnator = true;

        if(!expugnator) {
            ogE.addElement(new OptionsGruppeEintrag("Kettenschwert", 0));
    		ogE.addElement(new OptionsGruppeEintrag("Boltpistole", 0));
        }
		ogE.addElement(new OptionsGruppeEintrag("Flammen-Pistole", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma-Pistole", 15));
		ogE.addElement(new OptionsGruppeEintrag("Infernus-Pistole", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energieklaue", 15));
		ogE.addElement(new OptionsGruppeEintrag("Sturmschild", 20));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 25));
		ogE.addElement(new OptionsGruppeEintrag("Energiehammer", 30));
		if(expugnator) { // Expugnator-Sarge has second group (see below)
			add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        } else {
			add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
            o1.setAnzahl(0, 1);
            o1.setAnzahl(1, 1);
        }

		if(expugnator) {
			seperator();

			ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 0));
			ogE.addElement(new OptionsGruppeEintrag("Energieklaue", 0));
			ogE.addElement(new OptionsGruppeEintrag("Karmesinklinge", "Karmesinrote Klinge", 0));
			ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 10));
			ogE.addElement(new OptionsGruppeEintrag("Energiehammer", 15));
			add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        }

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melterbomben", 5));
		
		if(!expugnator)
			add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Parierschild", 5));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
		if(expugnator && !o2.isSelected()) {
			o2.setSelected(0, true);
		}
        
        if(!expugnator) {
            o1.setLegal(o1.getAnzahl() == 2);
        }
	}

}
