package oc.wh40k.units.ab;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class ABGraceoftheThrone extends Eintrag {

    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;
    OptionsUpgradeGruppe o3;
    OptionsUpgradeGruppe o4;
    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe2;
    RuestkammerStarter rkAceCrew;

	public ABGraceoftheThrone() {
		name = "Grace of the Throne";
		grundkosten = 195;

        BuildaHQ.addToInformationVector("ABGraceoftheThrone", 1);

		add(ico = new oc.Picture("oc/wh40k/images/ABGraceoftheThrone.jpg"));
		

		ogE.addElement(new OptionsGruppeEintrag("Battle cannon", 0));
		ogE.addElement(new OptionsGruppeEintrag("Exterminator", "Exterminator autocannons", 0));
		ogE.addElement(new OptionsGruppeEintrag("Conqueror", "Conqueror cannon and co-axial storm bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Annihilator", "T/L Annihilator autocannons", 0));
		ogE.addElement(new OptionsGruppeEintrag("Vanquisher", "Vanquisher battle cannon", 5));
		ogE.addElement(new OptionsGruppeEintrag("Eradicator", "Eradicator Nova cannon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Demolisher", "Demolisher cannon", 5));
		ogE.addElement(new OptionsGruppeEintrag("Punisher", "Punisher Gatling cannon", 20));
		ogE.addElement(new OptionsGruppeEintrag("Executioner", "Executioner plasma cannon", 30));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Lascannon", 15));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("2 heavy bolters", "Pair of heavy bolters", 20));
		ogE.addElement(new OptionsGruppeEintrag("2 heavy flamers", "Pair of heavy flamers", 20));
		ogE.addElement(new OptionsGruppeEintrag("2 multi-meltas", "Pair of multi-meltas", 30));
		ogE.addElement(new OptionsGruppeEintrag("2 plasma cannons","Pair of plasma cannons", 40));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Co-axial storm bolter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Co-axial heavy stubber", 10));
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Heavy stubber", 10));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Storm bolter", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Hunter-killer missile", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Dozerblade", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Extra armour", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Camo-netting", 20));

		seperator();

		rkAceCrew = new RuestkammerStarter(ID, randAbstand, cnt, "ABAceCrewKammer", "Ace Crew Skills");
		rkAceCrew.initKammer();
        rkAceCrew.setButtonText("Ace Crew Skills");
		add(rkAceCrew);

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);

        o1.alwaysSelected();
        o2.alwaysSelected();

        o4.setAktiv(o1.isSelected("Vanquisher battle cannon"));

        oe1.setAktiv(!oe2.isSelected());
        oe2.setAktiv(!oe1.isSelected());

//        boolean cannon = o1.isSelected("Battle cannon") || o1.isSelected("Demolisher cannon");
//        rkAceCrew.getKammer().switchEntry("SLICKLOADER", cannon);
	}

    @Override
    public void deleteYourself() {
        super.deleteYourself();
        BuildaHQ.addToInformationVector("ABGraceoftheThrone", -1);

        BuildaHQ.getChooserGruppe(1).refreshAllEntries();
        BuildaHQ.getChooserGruppe(2).refreshAllEntries();
        BuildaHQ.getChooserGruppe(3).refreshAllEntries();
        BuildaHQ.getChooserGruppe(4).refreshAllEntries();
        BuildaHQ.getChooserGruppe(5).refreshAllEntries();
    }

}
