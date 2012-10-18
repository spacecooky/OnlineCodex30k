package oc.wh40k.units.sm;

import oc.AnzahlPanel;
import oc.OnlineCodex;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class SMDevastorTrupp extends SM_CanHaveValthexHellfireRounds {

	AnzahlPanel squad;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkTransport;
	RuestkammerStarter rkPod;
        
        boolean siegeForce;

	public SMDevastorTrupp() {
		name = "Devastor-Trupp\n";
		grundkosten = 0;
		überschriftSetzen = true;

                siegeForce = OnlineCodex.getInstance().isCurrentArmy(oc.wh40k.armies.VOLKSiegeVanguardIA10.class);
		squad = new AnzahlPanel(ID, randAbstand, cnt, "Space Marines", 5, 10, 16);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/SMDevastatorTrupp.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 15));
		ogE.addElement(new OptionsGruppeEintrag("Multimelter", 15));
		ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Plasmakanone", 25));
		ogE.addElement(new OptionsGruppeEintrag("Laserkanone", 35));
		add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

		seperator();
        
                add(hellfire = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Höllenfeuer-Geschoße", 0));
                hellfire.setToolTipText("Werden durch Armenneus Valthex frei geschaltet. Maximal 1x pro Armee wählbar.");

                seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "SMSergeant", "Upgrade zum Sergeant");
		rkBoss.initKammer(true, true, false, false);
		add(rkBoss);
		rkBoss.setAbwaehlbar(false);

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "SMTransporterKammer", "Transporter");
		rkTransport.initKammer(false, true);
		rkTransport.setButtonText("Transporter");
		add(rkTransport);

                if(!siegeForce) {
                
                    seperator();

                    rkPod = new RuestkammerStarter(ID, randAbstand, cnt, "SMDropPodKammer", "Landungskapsel");
                    rkPod.initKammer(false);
                    rkPod.setButtonText("Landungskapsel");
                    rkPod.setSeperator(0);
                    add(rkPod);
                    
                }

		complete();
	}

	@Override
	public void refreshen() {
                if(!rkBoss.isSelected()) rkBoss.setSelected(true);
        
                if(!siegeForce) {
                
                    rkTransport.setAktiv(!rkPod.isSelected());
                    rkPod.setAktiv(!rkTransport.isSelected());
                    
                }
        
                super.checkHellfireRounds();
	}

}