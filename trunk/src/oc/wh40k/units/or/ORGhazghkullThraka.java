package oc.wh40k.units.or;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class ORGhazghkullThraka extends Eintrag {

	OptionsEinzelUpgrade Munigrot;

	public ORGhazghkullThraka() {

		kategorie = 1;



		name = "Ghazghkull Thraka";

		grundkosten = 225;



		add(ico = new oc.Picture("oc/wh40k/images/GhazghkullThraka.gif"));





		seperator();



		Munigrot = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Munigrot", 3);

		add(Munigrot);



		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Gargbosse");
        BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Bosse");
        BuildaHQ.addToInformationVector("ORWaaghboss", 1);



		complete();



	}

	@Override
    public void deleteYourself() {  
        BuildaHQ.addToInformationVector("ORWaaghboss", -1);
        if (BuildaHQ.getCountFromInformationVector("ORWaaghboss") <= 0) {
            BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Gargbosse");
            BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Bosse");
        }
        super.deleteYourself();
    }

	//@OVERRIDE
	public void refreshen() {
        setUnikat(true);
	}
}
