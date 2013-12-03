package oc.wh30k.units.sh;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class SHContemptorMortisDreadnought extends Eintrag {

	OptionsUpgradeGruppe o1, o2, o4;
	OptionsZaehlerGruppe o3;
	RuestkammerStarter rkTransport;

	public SHContemptorMortisDreadnought () {
		name = "Contemptor-Mortis Dreadnought";
		grundkosten = 155;

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Twin-linked heavy bolters", 0));
		ogE.addElement(new OptionsGruppeEintrag("Multi-meltas", 0));
		ogE.addElement(new OptionsGruppeEintrag("Twin-linked autocannons", 10));
		ogE.addElement(new OptionsGruppeEintrag("Assault cannons", "Kheres pattern assault cannons", 25));
		ogE.addElement(new OptionsGruppeEintrag("Twin-linked lascannons", 30));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Extra Armour", 10));		
		ogE.addElement(new OptionsGruppeEintrag("Havoc launcher", 15));
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 2));
		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "SHTransporterKammer", "Dedicated transport");
		//Rhino, Pod, Dreadclaw, Phobos, Spartan
		rkTransport.initKammer(false, true, true, false, false);
		rkTransport.setButtonText("Dedicated transport");
		add(rkTransport);
		
        complete();
	}

	@Override
	public void refreshen() {
			if (!o1.isSelected()) o1.setSelected(0, true);
    		
	}

}
