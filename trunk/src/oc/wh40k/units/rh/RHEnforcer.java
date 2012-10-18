package oc.wh40k.units.rh;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class RHEnforcer extends Eintrag {

	OptionsUpgradeGruppe nk;
	OptionsUpgradeGruppe fk;
	OptionsUpgradeGruppe afk;

	public RHEnforcer() {
		name = "Enforcer";
		grundkosten = 40;
		this.setEintragsCNT(0);
		
		BuildaHQ.addToInformationVector("RHEnforcer", +1);

		add(ico = new oc.Picture("oc/wh40k/images/RHEnforcer.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 2));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 10));
		add(fk = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Lasgun", 1));
		ogE.addElement(new OptionsGruppeEintrag("Autogun", 1));
		ogE.addElement(new OptionsGruppeEintrag("Shotgun", 1));
		add(afk = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power fist", 15));
		add(nk = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand + 10, cnt, "option", "Melta bombs", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand + 10, cnt, "option", "Carapace Armour", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand + 10, cnt, "option", "Refractor field", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand + 10, cnt, "option", "Demolition charge", 20));
		
		complete();
	}

	@Override
	public void refreshen() {
		if(BuildaHQ.getCountFromInformationVector("RHEnforcer") > 5) {
			setFehlermeldung("0-5 Auswahl!");
		} else {
			setFehlermeldung("");
		}
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
		BuildaHQ.addToInformationVector("RHEnforcer", -1);
	}

}
