
package oc.wh40k.units.cm2007;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class CM2007ChaosPredatorKammer extends RuestkammerVater {

	OptionsUpgradeGruppe o1;

        boolean child;
        
	public CM2007ChaosPredatorKammer() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
            name = "Chaos-Predator\n";
            grundkosten = 70;

            try {
                child = defaults[0];
            } catch(Exception e) {}

            add(ico = new oc.Picture("oc/wh40k/images/ChaosPredator.gif"));
            
            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Maschinenkanone", 0));
            if(child) ogE.addElement(new OptionsGruppeEintrag("Blastmaster", 0));
            ogE.addElement(new OptionsGruppeEintrag("Sync. Laserkanone", "Synchronisierte Laserkanone", 35));
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("2 Schwere Bolter", 30));
            if(child) ogE.addElement(new OptionsGruppeEintrag("2 Sonic Blaster", 30));
            ogE.addElement(new OptionsGruppeEintrag("2 Laserkanonen", 60));
            add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator(5);

            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozerschaufel", 5));
            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 15));
            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dämonenmaschine", 20));
            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Litanei des Chaos", 5));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Sync. Bolter", "Synchronisierter Bolter", 5));
            ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
            ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 10));
            ogE.addElement(new OptionsGruppeEintrag("Kombi-Flammenwerfer", 10));
            ogE.addElement(new OptionsGruppeEintrag("Inferno-Raketenwerfer", 15));
            add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            sizeSetzen();
	}

	@Override
	public void refreshen() {
		o1.alwaysSelected();
	}

}
