package oc.wh40k.units.cm;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CMChaosSpartanAssaultTank extends Eintrag {

	OptionsEinzelUpgrade chronus;

	boolean chronusSelected = false;
    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o3;

	public CMChaosSpartanAssaultTank() {
		name = "Spartan Assault Tank";
		grundkosten = 290;

		add(ico = new oc.Picture("oc/wh40k/images/SMSpartanAssaultTank.jpg"));

		seperator();

        ogE.addElement(new OptionsGruppeEintrag("TL Heavy Bolter", "twin-linked heavy bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("TL Heavy Flamer", "Twin-linked heavy flamer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Reaper autocannon", "Twin-linked heavy flamer", 0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Daemonic Possession", 20));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Havoc Launcher", 15));
		ogE.addElement(new OptionsGruppeEintrag("Combi-melta", 10));
		ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", 10));
        ogE.addElement(new OptionsGruppeEintrag("Twin-linked bolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 15));
		ogE.addElement(new OptionsGruppeEintrag("Multi-melta", 20));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		complete();
	}

	@Override
	public void refreshen() {
        o1.alwaysSelected();
	}
}
