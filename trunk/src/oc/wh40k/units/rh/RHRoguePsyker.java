package oc.wh40k.units.rh;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class RHRoguePsyker extends Eintrag {

	public RHRoguePsyker() {
		name = "Rogue Psyker";
		grundkosten = 15;
		this.setEintragsCNT(0);

		BuildaHQ.addToInformationVector("RHRoguePsyker", +1);
		
		add(ico = new oc.Picture("oc/wh40k/images/RHRoguePsyker.gif"));
		

		ogE.addElement(new OptionsGruppeEintrag("Additional CCW","Additional close combat weapon", 1));
		ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 2));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add (new OptionsEinzelUpgrade(ID, randAbstand, cnt, "","2nd Psy Table roll",10));
		complete();
	}

	@Override
	public void refreshen() {
		if(BuildaHQ.getCountFromInformationVector("RHRoguePsyker") > 5) {
			setFehlermeldung("0-5 Auswahl!");
		} else {
			setFehlermeldung("");
		}
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
		BuildaHQ.addToInformationVector("RHRoguePsyker", -1);
	}

}
