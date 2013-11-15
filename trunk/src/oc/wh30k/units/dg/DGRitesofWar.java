package oc.wh30k.units.dg;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class DGRitesofWar extends Eintrag {

	OptionsUpgradeGruppe o1;

	public DGRitesofWar() {
		name = "Rites of War";
		überschriftSetzen = true;
		this.setEintragsCNT(0);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Angel's wrath", 0));
		ogE.addElement(new OptionsGruppeEintrag("Armoured spearhead", 0));
		ogE.addElement(new OptionsGruppeEintrag("Orbital assault", 0));
		ogE.addElement(new OptionsGruppeEintrag("Pride of the Legion", 0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		
		complete();
	}

	

	@Override
	public void refreshen() {		
				
		if (!o1.isSelected()) o1.setSelected(0, true);
		
		if (o1.isSelected(0)) BuildaHQ.setInformationVectorValue("DGRoW", 1);
		else if (o1.isSelected(1)) BuildaHQ.setInformationVectorValue("DGRoW", 2);
		else if (o1.isSelected(2)) BuildaHQ.setInformationVectorValue("DGRoW", 3);
		else if (o1.isSelected(3)) BuildaHQ.setInformationVectorValue("DGRoW", 4);
		
		int selectedSquads = 1;
		int possibleSquads = BuildaHQ.getCountFromInformationVector("DGPraetor");
		if(selectedSquads > possibleSquads) {
			setFehlermeldung("No Legion Praetor!");
		} else {
			setFehlermeldung("");
		}
		
		setUnikat(true);
		
		
	}

}
