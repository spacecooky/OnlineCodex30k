package oc.whfb.units.bdc;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class BDCCentigor extends Eintrag {

	AnzahlPanel squad;
	OptionsUpgradeGruppe o1;

	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;

	OptionsEinzelUpgrade oeS;
	OptionsEinzelUpgrade oeM;

	public BDCCentigor() {
		name = BuildaHQ.translate("Centigor");
		grundkosten = 0;
		
		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Centigor"), 5, 100, 25);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/images/DEAdliger.jpg"));
		
		seperator();
		
		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Wurfäxte"), 2));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Zweihandwaffen"), 2));
		
		seperator();
		
		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musiker"), 7));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Standartenträger"), 14));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Champion"), 14));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));


		complete();
	}

	@Override
	public void refreshen() {
		oe1.setPreis(squad.getModelle() * 2);
		oe2.setPreis(squad.getModelle() * 2);
	}
}
