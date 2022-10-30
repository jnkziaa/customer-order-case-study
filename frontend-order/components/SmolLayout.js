import styles from '../styles/layout.module.css'

export default function SmolLayout(props) {
    return (
        <div className={styles.layout}>
            {props.children}
        </div>
    )
}