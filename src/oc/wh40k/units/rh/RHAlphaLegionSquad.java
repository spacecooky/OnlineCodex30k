package oc.wh40k.units.rh;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class RHAlphaLegionSquad extends Eintrag {

	AnzahlPanel squad;
	OptionsUpgradeGruppe o6;
	OptionsUpgradeGruppe o7;
	OptionsUpgradeGruppe o8;
	OptionsEinzelUpgrade boss;
	OptionsUpgradeGruppe bossNK;
	OptionsUpgradeGruppe bossFK;
	OptionsUpgradeGruppe bossFK2;
	OptionsEinzelUpgrade mb;
	RuestkammerStarter rkRhino;
	OptionsEinzelUpgrade rkDread;

	public RHAlphaLegionSquad() {
		name = "Alpha Legion Squad\n";
		grundkosten = 0;
		überschriftSetzen=true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Chaos Marines", 5, 10, 15);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/ChaosSpaceMarines.gif"));
		

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
		ogE.addElement(new OptionsGruppeEintrag("Plasma gun", 15));
		ogE.addElement(new OptionsGruppeEintrag("Meltagun", 10));
		ogE.addElement(new OptionsGruppeEintrag("Flamer", 5));
		add(o7 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();


		ogE.addElement(new OptionsGruppeEintrag("Icon of Glory Chaos", 10));
		add(o6 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();

		add(boss = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "","Aspiring Champion", "Upgrade to Aspiring Champion",10));
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 15));
		ogE.addElement(new OptionsGruppeEintrag("Power fist", 25));
		add(bossNK = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
		add(bossFK = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("TL Boltgun","Twinlinked Boltgun", 5));
		ogE.addElement(new OptionsGruppeEintrag("Combi-Melta", 10));
		ogE.addElement(new OptionsGruppeEintrag("Combi-Flamer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Combi-Plasma", 10));
		add(bossFK2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));
		
		seperator();
		
		add(mb = new OptionsEinzelUpgrade(ID, randAbstand + 10, cnt, "option", "Melta bombs", 5));
		
		seperator();
		
		rkRhino = new RuestkammerStarter(ID, randAbstand, cnt, "RHRhino", "Rhino");
		rkRhino.initKammer();
		rkRhino.setButtonText("Rhino");
		add(rkRhino);

		add(rkDread = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "","Dreadclaw",65));
		
		BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("Arkos the Faithless");
        BuildaHQ.addToInformationVector("RHAlphaLegion", 1);
		
		complete();
	}

	
	 @Override
	    public void deleteYourself() {
	        BuildaHQ.addToInformationVector("RHAlphaLegion", -1);
	        if(BuildaHQ.getCountFromInformationVector("RHAlphaLegion") <= 0) {
	            BuildaHQ.getChooserGruppe(1).removeSpezialAuswahl("Arkos the Faithless");
	        }
	        super.deleteYourself();
	    }
	
	@Override
	public void refreshen() {
		bossNK.setAktiv(boss.isSelected());
		bossFK.setAktiv(boss.isSelected());
		bossFK2.setAktiv(boss.isSelected());
		mb.setAktiv(boss.isSelected());

		rkRhino.setAktiv(!rkDread.isSelected());
		rkDread.setAktiv(!rkRhino.isSelected());
		
	}

}