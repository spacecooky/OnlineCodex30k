package oc.wh40k.units.ta;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class TADornenhai extends Eintrag {

	OptionsUpgradeGruppe o3;
	RuestkammerStarter o6;

	public TADornenhai() {
		System.out.println("Dornenhai-Kammer");
		name = "Dornenhai";
		grundkosten = 125;
        
        BuildaHQ.addToInformationVector("TA2006Dornenhai", 1);

		add(ico = new oc.Picture("oc/wh40k/images/Dornenhai.gif"));
		

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("2 Pulskanonen", 10));
		ogE.addElement(new OptionsGruppeEintrag("2 Angriffsdrohnen", 20));
		ogE.addElement(new OptionsGruppeEintrag("Schwärmer Raketensystem", 20));

		o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE);
		add(o3);

		seperator();

		o6 = new RuestkammerStarter(ID, randAbstand, cnt, "TADornenhaiKammer", "Dornenhai");
		o6.initKammer(false);
		o6.setButtonText("Rüstkammer");
		add(o6);

		complete();
	}

    @Override
	public void refreshen() {
		if(!o3.isSelected()) o3.setSelected(0, true);

        // O'Shova Sonderregel beachten
        int currentUnitCount = BuildaHQ.getCountFromInformationVector("TA2006Dornenhai");
        boolean oshova = BuildaHQ.getCountFromInformationVector("TA2006OShovah") == 0 ? false : true;
        if(oshova && currentUnitCount > 1) setFehlermeldung("0-1 wgegen O'Shova");
        else setFehlermeldung("");
	}

    @Override
    public void deleteYourself() {
        super.deleteYourself();
        BuildaHQ.addToInformationVector("TA2006Dornenhai", -1);
    }

}
