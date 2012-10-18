package oc.wh40k.units.sm;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.OnlineCodex;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class SMSturmtrupp extends SM_CanHaveValthexHellfireRounds {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsEinzelUpgrade jet;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkRhino;
	RuestkammerStarter rkPod;
        
        boolean siegeForce;

	public SMSturmtrupp() {
		name = "Sturmtrupp\n";
		grundkosten = 0;
		überschriftSetzen = true;

                siegeForce = OnlineCodex.getInstance().isCurrentArmy(oc.wh40k.armies.VOLKSiegeVanguardIA10.class);
                
		squad = new AnzahlPanel(ID, randAbstand, cnt, "Space Marines", 5, 10, 18);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/SMSturmtrupp.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 15));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, -88));

		seperator();

		add(jet = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sprungmodule", 0));
		jet.setSelected(true);
        
                seperator();

                add(hellfire = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Höllenfeuer-Geschoße", 0));
                hellfire.setToolTipText("Werden durch Armenneus Valthex frei geschaltet. Maximal 1x pro Armee wählbar.");

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "SMSturmtruppSergeant", "Upgrade zum Sergeant");
		rkBoss.initKammer();
		add(rkBoss);
		rkBoss.setAbwaehlbar(false);

		seperator();

		rkRhino = new RuestkammerStarter(ID, randAbstand, cnt, "SMTransporterKammer", "");
		rkRhino.initKammer(true, false);
		rkRhino.setButtonText("Transporter");
		rkRhino.setUeberschriftTrotzNullKostenAusgeben(false);
		add(rkRhino);

                if(!siegeForce) {
                
                    seperator();

                    rkPod = new RuestkammerStarter(ID, randAbstand, cnt, "SMDropPodKammer", "Landungskapsel");
                    rkPod.initKammer(false, true);
                    rkPod.setButtonText("Landungskapsel");
                    rkPod.setSeperator(0);
                    add(rkPod);
                    
                }

		complete();
	}

	@Override
	public void refreshen() {
                if(!rkBoss.isSelected()) rkBoss.setSelected(true);
        
		o1.setMaxAnzahl(squad.getModelle() / 5);
                
                if(!siegeForce) {
                    
                    rkRhino.setAktiv(!jet.isSelected() && !rkPod.isSelected());
                    rkPod.setAktiv(!jet.isSelected() && !rkRhino.isSelected());
                    
                } else {
                    
                    rkRhino.setAktiv(!jet.isSelected());
                    
                }
        
                super.checkHellfireRounds();
                hellfire.setAktiv(BuildaHQ.getCountFromInformationVector("SMArmenneusValthex") > 0 && !jet.isSelected());
	}

}
