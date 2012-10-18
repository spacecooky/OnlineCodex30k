
package oc.wh40k.units.cm2007;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class CM2007ChaosgeneralKammer extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;
	OptionsUpgradeGruppe o4;
        OptionsEinzelUpgrade termi;
        OptionsEinzelUpgrade oe1;
        OptionsEinzelUpgrade oe2;

        boolean terminatorPreselected;
        boolean child;

	public CM2007ChaosgeneralKammer() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
            name = "Chaosgeneral\n";
            grundkosten = 90;

            try {
                terminatorPreselected = defaults[0];
                child = defaults[1];
            } catch(Exception e) {}

            add(ico = new oc.Picture("oc/wh40k/images/ChaosLordinPowerArmour.gif"));
            
            seperator(8);

            ogE.addElement(new OptionsGruppeEintrag("Mal des Slaanesh", child ? 0 : 5));
            if(!child) ogE.addElement(new OptionsGruppeEintrag("Mal des Khorne", 10));
            if(!child) ogE.addElement(new OptionsGruppeEintrag("Mal des Nurgle", 20));
            if(!child) ogE.addElement(new OptionsGruppeEintrag("Mal des Tzeentch", 15));
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            add(termi = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Terminatorrüstung", 30));

            seperator(8);

            ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 15));
            ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 25));
            ogE.addElement(new OptionsGruppeEintrag("Energieklaue", 25));
            ogE.addElement(new OptionsGruppeEintrag("Energieklauenpaar", 30));
            ogE.addElement(new OptionsGruppeEintrag("Dämonenwaffe", 40));
            ogE.addElement(new OptionsGruppeEintrag("Kettenfaust",15));
            add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator(5);

            ogE.addElement(new OptionsGruppeEintrag("synchronisierter Bolter", 5));
            ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
            ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 10));
            ogE.addElement(new OptionsGruppeEintrag("Kombi-Flammenwerfer", 10));
            add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator(8);

            if(child) add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Schockbooster", 10));
            add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Plasmapistole", 15));
            add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melterbomben", 5));
            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Persönliche Ikone", 5));

            seperator(5);

            ogE.addElement(new OptionsGruppeEintrag("Sprungmodul", 20));
            ogE.addElement(new OptionsGruppeEintrag("Flügel", 20));
            ogE.addElement(new OptionsGruppeEintrag("Chaosbike", 30));
            ogE.addElement(new OptionsGruppeEintrag("Dämonisches Reittier", 30));
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            sizeSetzen();
	}

	@Override
	public void refreshen() {
            if(terminatorPreselected) termi.setSelected(true);
            if(child) o2.alwaysSelected();

            o1.setAktiv(!termi.isSelected());
            o1.setAktiv("Dämonisches Reittier", o2.isSelected() && !termi.isSelected());
            o4.setPreis("Kombi-Melter", termi.isSelected() ? 5 : 10);
            o4.setPreis("Kombi-Plasmawerfer", termi.isSelected() ? 5 : 10);
            o4.setPreis("Kombi-Flammenwerfer", termi.isSelected() ? 5 : 10);
            o3.setPreis("Energiefaust",termi.isSelected() ? 10 : 25);
            o3.setPreis("Energieklaue",termi.isSelected() ? 10 : 25);
            o3.setPreis("Energieklauenpaar",termi.isSelected() ? 10 : 30);
            o3.setPreis("Dämonenwaffe",termi.isSelected() ? 25 : 40);
            o4.setPreis("synchronisierter Bolter", termi.isSelected() ? 0 : 5);
            o3.setPreis("Energiewaffe",termi.isSelected() ? 0 : 15);
            o3.setAktiv("Kettenfaust", termi.isSelected());
            oe1.setAktiv(!termi.isSelected());
            oe2.setAktiv(!termi.isSelected());
            if (termi.isSelected()) {
                  if(!o3.isSelected()) o3.setSelected("Energiewaffe",true);
                  if(!o4.isSelected()) o4.setSelected("synchronisierter Bolter", true);
            }
            o4.setAktiv((termi.isSelected() && !o3.isSelected("Energieklauenpaar")) || !termi.isSelected());

	}

}
