package oc.wh40k.units.rh;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class RHApostatePreacher extends Eintrag {

	OptionsEinzelUpgrade relic;
	boolean relicBoolean = false;
	
	public RHApostatePreacher() {
		name = "Apostate Preacher";
		grundkosten = 40;
		this.setEintragsCNT(0);
		
		BuildaHQ.addToInformationVector("RHApostatePreacher", +1);

		add(ico = new oc.Picture("oc/wh40k/images/IGMinistrorumPriest.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 2));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 10));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power fist", 15));
		ogE.addElement(new OptionsGruppeEintrag("Eviscerator", 25));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();
		
		add(relic = new OptionsEinzelUpgrade(ID, randAbstand + 10, cnt, "option", "Unholy relic", 30));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Refractor field", 15));
		ogE.addElement(new OptionsGruppeEintrag("Rosarius", 25));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));
		add(new OptionsEinzelUpgrade(ID, randAbstand + 10, cnt, "option", "Melta bombs", 5));
		
		complete();
	}

	@Override
	public void refreshen() {
		if(BuildaHQ.getCountFromInformationVector("RHApostatePreacher") > 5) {
			setFehlermeldung("0-5 Auswahl!");
		} else {
			setFehlermeldung("");
		}
		
		if(relic.isSelected()!= relicBoolean){
			relicBoolean = !relicBoolean;
			if(relicBoolean){
				BuildaHQ.addToInformationVector("RHUnholyRelic", +1);
			} else {
				BuildaHQ.addToInformationVector("RHUnholyRelic", -1);
			}
		}
		
		relic.setAktiv(BuildaHQ.getCountFromInformationVector("RHUnholyRelic") == 0 || relic.isSelected());
		relic.setLegal(BuildaHQ.getCountFromInformationVector("RHUnholyRelic") < 2);
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
		BuildaHQ.addToInformationVector("RHApostatePreacher", -1);
	}

}
