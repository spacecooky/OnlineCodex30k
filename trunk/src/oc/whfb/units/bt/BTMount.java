package oc.whfb.units.bt;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class BTMount extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	
	public BTMount() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		// defaults[0] = Herzog
		// defaults[1] = Dame
		// defaults[2] = Paladin
		// defaults[3] = Maid

		boolean commander = (defaults[0] || defaults[1]);
		
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Gepanzertes Schlachtross"), commander ? 21 : 14));
		if(defaults[1] || defaults[3]) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schlachtross"), commander ? 15 : 10));
		
		if(defaults[0])ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Hippogreif"), 200));
		if(defaults[0]||defaults[2]||defaults[1])ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Pegasus"), 50));
		
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		if(defaults[0]||defaults[2])o1.setSelected(BuildaHQ.translate("Gepanzertes Schlachtross"), true);
		setUeberschrift(BuildaHQ.translate("Reittier"));
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		boolean herzog = ( BuildaHQ.getCountFromInformationVector("BT_HERZOG") > 0 ? true : false );
		if(o1.isSelected(BuildaHQ.translate("Pegasus")) && herzog)BuildaHQ.setInformationVectorValue("BT_PEGGIE", 1);
		else if (!o1.isSelected(BuildaHQ.translate("Pegasus")) && herzog)BuildaHQ.setInformationVectorValue("BT_PEGGIE", 0);
	}
}
