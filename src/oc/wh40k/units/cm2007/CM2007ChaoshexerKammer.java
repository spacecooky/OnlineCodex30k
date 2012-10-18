
package oc.wh40k.units.cm2007;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class CM2007ChaoshexerKammer extends RuestkammerVater {

	OptionsEinzelUpgrade o1;
	OptionsEinzelUpgrade o2;
	OptionsEinzelUpgrade o3;
	OptionsEinzelUpgrade o4;
	OptionsUpgradeGruppe o5;
	OptionsUpgradeGruppe o6;
	OptionsUpgradeGruppe o7;
	OptionsEinzelUpgrade ot;
	OptionsUpgradeGruppe ot1;

        boolean sons = false;
        boolean child = false;

	public CM2007ChaoshexerKammer() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
            name = "Chaoshexer\n";
            grundkosten = 100;

            try {
                sons = defaults[0];  //Thousand Sons
                child = defaults[1]; //Emperor's Children

            } catch(Exception e) {}

            add(ico = new oc.Picture("oc/wh40k/images/ChaosSorcerer.gif"));
            
            seperator();

            if(!sons && ! child) ogE.addElement(new OptionsGruppeEintrag("Mal des Nurgle", 20));
            if(!child) ogE.addElement(new OptionsGruppeEintrag("Mal des Tzeentch", sons ? 0 : 30));
            if(!sons) ogE.addElement(new OptionsGruppeEintrag("Mal des Slaanesh", child ? 0 : 5));
            add(o6 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Strahl des Verderbens", 10));
            ogE.addElement(new OptionsGruppeEintrag("Warpzeit", 25));
            ogE.addElement(new OptionsGruppeEintrag("Chaoswind", 30));
            ogE.addElement(new OptionsGruppeEintrag("Geschenk des Chaos", 30));
            if(!sons && !child) ogE.addElement(new OptionsGruppeEintrag("Fäulnis des Nurgle", 15));
            if(!child) ogE.addElement(new OptionsGruppeEintrag("Blitz des Tzeentch", 25));
            if(!sons) ogE.addElement(new OptionsGruppeEintrag("Peitsche der Unterwerfung", 20));
            add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Sprungmodul", 20));
            ogE.addElement(new OptionsGruppeEintrag("Flügel", 20));
            ogE.addElement(new OptionsGruppeEintrag("Chaosbike", 30));
            ogE.addElement(new OptionsGruppeEintrag("Dämonisches Reittier", 30));
            add(o7 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator(5);

            if(child) add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Schockbooster", 5));
            add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Plasmapistole", 15));
            add(o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melterbomben", 5));
            add(o3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Persönliche Ikone", 5));
            add(o4 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Homunkulus", 5));

            seperator();

            add(ot = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Terminatorrüstung", 15));

            seperator(5);

            ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 5));
            ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 5));
            ogE.addElement(new OptionsGruppeEintrag("Kombi-Flammenwerfer", 5));
            add(ot1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

            sizeSetzen();
	}

	@Override
	public void refreshen() {
            if(sons || child) o6.alwaysSelected();

            o5.setAktiv("Fäulnis des Nurgle", o6.isSelected("Mal des Nurgle"));
            o5.setAktiv("Peitsche der Unterwerfung", o6.isSelected("Mal des Slaanesh"));
            o5.setAktiv("Blitz des Tzeentch", o6.isSelected("Mal des Tzeentch"));
            o5.setMaxAnzahl(1 + (o6.isSelected("Mal des Tzeentch") ? 1 : 0) + (o4.isSelected() ? 1 : 0));

            o1.setAktiv(!ot.isSelected());
            o2.setAktiv(!ot.isSelected());
            o7.setAktiv(!ot.isSelected());
            ot1.setAktiv(ot.isSelected());

            if(o7.isAktiv()) {
                    o7.setAktiv("Dämonisches Reittier", o6.isSelected());
            }
	}

}
