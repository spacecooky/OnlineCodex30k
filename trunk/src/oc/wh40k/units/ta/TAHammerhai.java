package oc.wh40k.units.ta;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class TAHammerhai extends Eintrag {

	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;
	RuestkammerStarter o6;

	public TAHammerhai() {
		name = "Hammerhai";
		grundkosten = 90;
        
        BuildaHQ.addToInformationVector("TA2006Hammerhai", 1);

		add(ico = new oc.Picture("oc/wh40k/images/Hammerhai.gif"));
		

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Ionenkanone", 15));
		ogE.addElement(new OptionsGruppeEintrag("Massebeschleuniger", 50));
		ogE.addElement(new OptionsGruppeEintrag("L/B burst cannon [IA3]", "Twin-linked long barralled burst cannons [IA3]", 15));
		ogE.addElement(new OptionsGruppeEintrag("T/L Missile pods [IA3]", "Twin-linked missile pods [IA3]", 15));
		ogE.addElement(new OptionsGruppeEintrag("T/L fusion cannons [IA3]", "Twin-linked fusion cannons [IA3]", 30));
		ogE.addElement(new OptionsGruppeEintrag("T/L plasma cannons [IA3]", "Twin-linked plasma cannons [IA3]", 15));
		o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE);
		add(o2);
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("2 Pulskanonen", 10));
		ogE.addElement(new OptionsGruppeEintrag("2 Angriffsdrohnen", 20));
		ogE.addElement(new OptionsGruppeEintrag("Schwärmer Raketensystem", 20));

		o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE);
		add(o3);

		seperator();

		o6 = new RuestkammerStarter(ID, randAbstand, cnt, "TAHammerhaiKammer", "Hammerhai");
		o6.initKammer(true, false);
		o6.setButtonText("Rüstkammer");
		add(o6);

		complete();
	}

    @Override
	public void refreshen() {
		if(!o2.isSelected()) o2.setSelected(0, true);
		if(!o3.isSelected()) o3.setSelected(0, true);

        // O'Shova Sonderregel beachten
        int currentUnitCount = BuildaHQ.getCountFromInformationVector("TA2006Hammerhai");
        boolean oshova = BuildaHQ.getCountFromInformationVector("TA2006OShovah") == 0 ? false : true;
        if(oshova && currentUnitCount > 1) setFehlermeldung("0-1 wgegen O'Shova");
        else setFehlermeldung("");
	}

    @Override
    public void deleteYourself() {
        super.deleteYourself();
        BuildaHQ.addToInformationVector("TA2006Hammerhai", -1);
    }

}
