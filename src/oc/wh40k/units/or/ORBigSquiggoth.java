package oc.wh40k.units.or;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class ORBigSquiggoth extends Eintrag {
        OptionsUpgradeGruppe o1;
        OptionsEinzelUpgrade madDokCybork;

	public ORBigSquiggoth() {
		name = "Big Squiggoth";
		grundkosten = 50;

		add(ico = new oc.Picture("oc/wh40k/images/BigSquiggoth.jpg"));
		


		ogE.addElement(new OptionsGruppeEintrag("Kannon", 20));
		ogE.addElement(new OptionsGruppeEintrag("Lobba", 25));
		ogE.addElement(new OptionsGruppeEintrag("Zzap Gun", 20));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(madDokCybork = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grotsniks Cybork-Körpa", 5));

		complete();
	}

	//@OVERRIDE
	public void refreshen() {
		if(BuildaHQ.getCountFromInformationVector("ORDokGrotsnik")>0){
			madDokCybork.setAktiv(true);
			
		} else {
			madDokCybork.setAktiv(false);
			madDokCybork.setSelected(false);
		}
	}

}
